const path = require("path");
const webpack = require('webpack');
const autoprefixer = require('autoprefixer');
const pxtorem = require('postcss-pxtorem');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextPlugin = require("extract-text-webpack-plugin");
// 引入多页面文件列表
const config = require("./build");
// 通过 html-webpack-plugin 生成的 HTML 集合
let HTMLPlugins = [];
// 入口文件集合
let Entries = {
    // "vendor1": ["react","react-dom"],
    // "vendor2": ["lodash"]
}
// 生成多页面的集合
config.HTMLDirs.forEach((page) => {
    const htmlPlugin = new HtmlWebpackPlugin({
        filename:`${page}.html`,
        template: path.resolve(__dirname, `app/${page}/index.html`),
        chunks: [page, 'commons'],
    });
    HTMLPlugins.push(htmlPlugin);
    Entries[page] = path.resolve(__dirname, `app/${page}/index`);
});
module.exports = {
    entry:Entries,
    devtool:"cheap-module-source-map",
    output:{
        filename:"js/[name].[hash:8].js",
        path:path.resolve(__dirname,"static")
    },
    // resolve: {
        // extensions: ['', '.web.js', '.jsx', '.js', '.json'],
        // modulesDirectories: ['node_modules', path.join(__dirname, '../node_modules')],
        // alias: {
        //     "jquery": path.resolve(__dirname, 'app/assets/jquery-vendor.js')
        // }
    // },
    externals : {
        'jquery' : 'window.jQuery'
    },
    module: {
        rules: [
            {
                test: /\.js|jsx$/,
                exclude: /node_modules/,
                loader: "babel-loader"
            },
            {
                test: /\.css/,
                exclude: /node_modules/,
                use: ExtractTextPlugin.extract({
                        fallback: 'style-loader',
                        use: [{
                            loader:'css-loader',
                            options:{minimize:false}
                        }]
                })
            },
            {
                test: /\.less/,
                exclude: /node_modules/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: [{
                        loader:'css-loader',
                        options:{minimize:false}
                    },{
                        loader: 'postcss-loader',
                        options: {
                            plugins: () => [autoprefixer(
                                { browsers: ['iOS >= 7', 'Android >= 4.1', 'last 10 Chrome versions', 'last 10 Firefox versions', 'Safari >= 6', 'ie > 8'] }
                            )
                                // ,pxtorem({
                                //     rootValue: 100,
                                //     minPixelValue: 1,
                                //     propWhiteList: [],
                                // })
                            ],
                        },
                    },{
                        loader: 'less-loader'
                    }]
                })
            },
            {
                test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
                exclude: /node_modules/,
                use:[
                    {
                        loader: 'url-loader',
                        options: {
                            limit: 2048,
                            name: 'img/[name].[ext]?[hash:8]',
                            publicPath: '../'
                        }
                    }
                ]
            },
            {
                test: /\.(woff|woff2|eot|ttf|otf)$/,
                exclude: /node_modules/,
                use:[
                    {
                        loader: 'file-loader',
                        options: {
                            name: 'img/[name].[ext]?[hash:8]',
                            publicPath: '../'
                        }
                    }
                ]
            },
            {
                test: /\.(htm|html)$/i,
                loader: 'html-withimg-loader'
            }
        ]
    },
    plugins:[
        new ExtractTextPlugin("css/[name].[hash:8].css"),
        new webpack.optimize.CommonsChunkPlugin({
            name: "commons",
            minChunks: 2,
            filename: "commons/[name].bundle.js",
        }),
        ...HTMLPlugins
    ]
}