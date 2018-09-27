var webpack = require('webpack');
var path = require('path');
var glob = require('glob');
var MiniCssExtractPlugin = require("mini-css-extract-plugin");
var PurifyCSSPlugin = require('purifycss-webpack');
var CleanWebPackPlugin = require('clean-webpack-plugin');
var devMode = process.env.NODE_ENV !== 'production';

module.exports = {
    mode: devMode ? "development" : "production",
    entry: [
        './src/main/js/app.js',
        './src/main/css/app.scss',
    ],

    output: {
        path: path.resolve(__dirname, './src/main/webapp/static/dist'),
        filename: '[name].js'
    },

    plugins: [

        new MiniCssExtractPlugin({
            filename: devMode ? '[name].css' : '[name].[chunkhash].css',
            chunkFilename: devMode ? '[id].css' : '[id].[chunkhash].css',
        }),

        // new PurifyCSSPlugin({
        //     paths: glob.sync(path.join(__dirname, 'src/main/webapp/WEB-INF/**/*.(jsp|tag)')),
        //     minimize: !devMode
        // }),

        // new CleanWebPackPlugin(['dist'], {
        //         root: path.join(__dirname, 'src/main/webapp/static'),
        //         verbose: true,
        //         dry: false
        //     }
        // ),

        function () {
            this.plugin('done', stats =>{
                require('fs').writeFileSync(
                    path.join(__dirname, 'src/main/webapp/static/dist/webpack.manifest.json'),
                    JSON.stringify(stats.toJson().assetsByChunkName)
                )
            })
        }
    ],

    module: {
        rules: [
            {
                test: /\.s[ac]ss$/,
                use: [
                    MiniCssExtractPlugin.loader,
                    'css-loader',
                    {
                        loader: "postcss-loader",
                        options: {
                            plugins: function () { // post css plugins, can be exported to postcss.config.js
                                return [
                                    require('precss'),
                                    require('autoprefixer')
                                ];
                            }
                        }
                    },
                    'sass-loader'
                ],
            },

            {
                test: /\.(png|jpe?g|gif|svg|eot|ttf|woff|woff2)$/,
                loader: 'file-loader',
                options: {
                    name: '/images/[name].[hash].[ext]'
                }
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
