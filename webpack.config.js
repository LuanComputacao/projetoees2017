var webpack = require('webpack');
var path = require('path');
var glob = require('glob-all');
var MiniCssExtractPlugin = require("mini-css-extract-plugin");
var PurifyCSSPlugin = require('purifycss-webpack');
var CleanWebPackPlugin = require('clean-webpack-plugin');
var CopyWebpackPlugin = require('copy-webpack-plugin');

var devMode = process.env.NODE_ENV !== 'production';

var sources = {
    'dist': './src/main/webapp/static/dist',
    'src': './src/main/assets',
    'nodeModules':  './node_modules',
};

module.exports = {
    mode: devMode ? "development" : "production",

    entry: [
        './src/main/assets/js/app.js',
        './src/main/assets/css/app.scss',
    ],

    output: {
        path: path.resolve(__dirname, sources.dist),
        filename: '[name].js'
    },

    plugins: [

        new CopyWebpackPlugin([{
            from: path.join(__dirname, sources.nodeModules + '/@fortawesome/fontawesome-free/webfonts'),
            to: path.join(__dirname, sources.src + '/webfonts'),

        }]),

        new MiniCssExtractPlugin({
            filename: devMode ? '[name].css' : '[name].[chunkhash].css',
            chunkFilename: devMode ? '[id].css' : '[id].[chunkhash].css',
        }),

        // new PurifyCSSPlugin({
        //     paths: glob.sync([
        //         path.join(__dirname, 'src/main/webapp/WEB-INF/**/*.jsp'),
        //         path.join(__dirname, 'src/main/webapp/WEB-INF/**/*.tag')
        //     ]),
        //     minimize: !devMode,
        //     purifyOptions: {
        //         whitelist: []
        //     }
        // }),

        new CleanWebPackPlugin(['dist'], {
                root: path.join(__dirname, 'src/main/webapp/static'),
                verbose: true,
                dry: false
            }
        ),

        function () {
            this.plugin('done', stats =>{
                require('fs').writeFileSync(
                    path.join(__dirname, sources.dist + '/webpack.manifest.json'),
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
                    name: 'static/dist/images/[name].[hash].[ext]',
                }
            },

            {
                test: /^\/src\/main\/assets\/js\/\.js$/,
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
