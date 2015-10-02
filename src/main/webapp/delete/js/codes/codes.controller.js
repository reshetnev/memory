angular
	.module('app')
	.controller('codesCtrl', codesCtrl);
	
function codesCtrl() {
	var vm = this;
	vm.codesList = codes;
}

codes = [																													
	{ 																														
		"name":"velcom", 	
		"password":"1234"			
	}, 																														
	{ 																														
		"name":"mts", 	
		"password":"5678"			
	}																														
]