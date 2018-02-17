// 引入基础配置文件
const webpackBase = require("./webpack.config.base");
// 引入 webpack-merge 插件
const webpackMerge = require("webpack-merge");
// 引入 webpack
const webpack = require("webpack");
// 合并配置文件
module.exports = webpackMerge(webpackBase,{
    // 配置 webpack-dev-server
    devServer: {
        contentBase: "static",//本地服务器所加载的页面所在的目录
            historyApiFallback: true,//不跳转
            inline: true,
            watchContentBase: true,
            watchOptions: {
            ignored: /node_modules/,
                aggregateTimeout: 100,
                poll: 1000
        },
        // proxy: {
        //     "/api": "http://localhost:8100"
        // }
    }
});