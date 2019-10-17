/* eslint-disable quotes */
const path = require('path');
module.exports = {
  configureWebpack: {
    resolve: {
      alias: {
        "@/modules": path.resolve(__dirname, 'src/modules'),
        "@/services": path.resolve(__dirname, 'src/services')
      }
    },
    devtool: 'source-map'
  }
}