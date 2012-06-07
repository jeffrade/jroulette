function userNameAvailable(){
	if(dojo.byId('userName').value.trim().length == 0){
		alert('Please Enter a User Name!');
	} else {
		dojoIsUserNameUnique(dojo.byId('userName').value);
	}
}

function dojoIsUserNameUnique(str){
	return dojo.xhrGet({
		url: 'checkUserName.htm',
		load: userNameCheckLoader,
		error: ajaxXhrError,
		content: {userName: str},
		preventCache: true
	});
}

/***********************
*** Loader Functions ***
***********************/
function userNameCheckLoader(response, ioArgs) {
	var e = dojo.byId('usrNameInd');
	var output = 'That User Name Is Taken';
	var color = 'red';
	if(response.toString().trim() == 'true'){
		output = 'Available';
		color = 'green';
	}
	e.innerHTML=output;
	e.style.color = color;
	return response;
}

/***********************
**** Error Functions *** 
***********************/
function ajaxXhrError(response, ioArgs) {console.log('ajaxXhrError: Error when retrieving data from the server! ' + response);/*alert('ajaxXhrError');*/return response;}


/*

<script>
function getLicenseAlternateCB() {
    //Look up the node we'll stick the text under.
    var targetNode = dojo.byId("getLicenseAlternateCB");

    //The parameters to pass to xhrGet, the url, how to handle it, and the callbacks.
    var xhrArgs = {
        url: "../_static/js/dojo/LICENSE",
        handleAs: "text",
        preventCache: true
    }

    //Call the asynchronous xhrGet
    var deferred = dojo.xhrGet(xhrArgs);

    //Now add the callbacks
    deferred.addCallback(function(data) {
        //Replace newlines with nice HTML tags.
        data = data.replace(/\n/g, "<br>");

        //Replace tabs with spacess.
        data = data.replace(/\t/g, "&nbsp;&nbsp;&nbsp;");

        targetNode.innerHTML = data;
    });

    deferred.addErrback(function(error) {
        targetNode.innerHTML = "An unexpected error occurred: " + error;
    });

}
dojo.addOnLoad(getLicenseAlternateCB);
</script>

*/