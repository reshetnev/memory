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
	},
	{ 																														
		"name":"velcom", 	
		"password":"1234"			
	}, 	
	{ 																														
		"name":"velcom", 	
		"password":"1234"			
	}, 	
	{ 																														
		"name":"velcom", 	
		"password":"1234"			
	}, 	
	{ 																														
		"name":"velcom", 	
		"password":"1234"			
	}, 	
	{ 																														
		"name":"velcom", 	
		"password":"1234"			
	}, 	
	{ 																														
		"name":"velcom", 	
		"password":"3333"			
	},
	{ 																														
		"name":"velcom", 	
		"password":"2222"			
	}, 	
	{ 																														
		"name":"velcom", 	
		"password":"1111"			
	} 		
]