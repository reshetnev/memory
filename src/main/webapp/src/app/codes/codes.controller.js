angular
	.module('app')
	.controller('codesCtrl', codesCtrl);
	
function codesCtrl() {
	var vm = this;
	vm.codesList = codes;
}