const path = require("path");

module.exports = {
  devServer: {
    proxy: {
        "/api": {
            target: "http://localhost:9000/api",
            changeOrigin: true,
            pathRewrite: {
                "^/api": "",
            },
        },
    },
  },

  transpileDependencies: [
    'vuetify'
  ],

  configureWebpack: {
    resolve: {
      alias: {
        "@": path.resolve(__dirname, "src/"),
        "@assets": path.resolve(__dirname, "src/assets"),
        "@components": path.resolve(__dirname, "src/components"),
        "@views": path.resolve(__dirname, "src/views"),
      },
    },
  },
} 
