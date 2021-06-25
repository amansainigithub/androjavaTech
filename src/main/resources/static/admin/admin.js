
function deleteCategoryOrChapter(cid,pattern)
{
		swal({
	  title: "Are you sure?",
	  text: "Once deleted, you will not be able to recover this image and data",
	  icon: "warning",
	  buttons: true,
	  dangerMode: true,
	})
	.then((willDelete) => {
	  if (willDelete) {
	  	
//	  	console.log(pattern)
//	  	console.log("/admin/adminpanel/"+pattern+"/"+cid);
	  	window.location="/admin/adminpanel/"+pattern+"/"+cid;
	   
	  } else {
	    swal("Your data is safe !!");
	  }
	});
}


  function DemoCtrl() {

				  this.foo = 'foo';
									  
		  		 CKEDITOR.editorConfig = function (config) {
				config.extraPlugins = 'confighelper';
				 };
	 CKEDITOR.replace('editor1');

	}
	
	angular
  .module('gaigDemo', ['gaigUiBootstrap'])
  .controller('DemoCtrl', DemoCtrl);