var webpack = require('webpack');
var path = require('path');

module.exports = {
    mode: "development",
    entry: './src/main/js/main.js',
    output: {
        path: path.resolve(__dirname, './src/main/webapp/static/dist/js'),
        filename: 'bundle.js'
    },
    module: {
        rules: [
            {
                test: /\.s[ac]ss$/,
                use: ['css-loader', 'sass-loader']
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
