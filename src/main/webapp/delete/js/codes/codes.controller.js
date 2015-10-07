angular
    .module('app.controllers')
    .controller('codesCtrl', codesCtrl);

function codesCtrl() {

    this.codesList = codes;
}

codes = [
         {
             "name": "mts",
             "password": "1234"
           },
           {
             "name": "velcom",
             "password": "5678"
           },
           {
             "name": "eight",
             "password": "eightPSW"
           },
           {
             "name": "nine",
             "password": "ninePSW"
           },
           {
             "name": "ten",
             "password": "tenPSW"
           }
         ]
