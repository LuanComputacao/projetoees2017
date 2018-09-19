var webpack = require('webpack');
var path = require('path');
var MiniCssExtractPlugin = require("mini-css-extract-plugin");
var devMode = process.env.NODE_ENV !== 'production';

module.exports = {
    mode: "development",
    entry: [
        './src/main/js/main.js',
        './src/main/css/style.scss',

        ],
    output: {
        path: path.resolve(__dirname, './src/main/webapp/static/dist'),
        filename: 'bundle.js'
    },
    plugins: [
        new MiniCssExtractPlugin({
            // Options similar to the same options in webpackOptions.output
            // both options are optional
            filename: devMode ? '[name].css' : '[name].[hash].css',
            chunkFilename: devMode ? '[id].css' : '[id].[hash].css',
        })
    ],
    module: {
        rules: [
            {
                test: /\.s[ac]ss$/,
                use: [
                    devMode ? 'style-loader' : MiniCssExtractPlugin.loader,
                    'css-loader',
                    'sass-loader'
                ],
            },

            {
                test: /^\/src\/main\/js\/\.js$/,
                exclude: /node_modules/,
                use: {
                    loader: 'babel-loader',
                    options: {
                        presets: ['@babel/preset-env']
                    }
                }
            }
        ]
    }
};
