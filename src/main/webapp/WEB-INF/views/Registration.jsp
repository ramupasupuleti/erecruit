<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<jsp:include page="../views/common.jsp"></jsp:include>
</head>
<body>
<div class="container">
            <form:form class="form-horizontal" commandName="RegistrationForm" action='/user/register' method='POST'>
                <h2>Registration Form</h2>
                <div class="form-group">
                    <form:label path="firstName" for="firstName" class="col-sm-3 control-label">First Name</form:label>
                    <div class="col-sm-9">
                        <form:input type="text" path="firstName" placeholder="First Name" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <form:label for="lastName" path="lastName" class="col-sm-3 control-label">Last Name</form:label>
                    <div class="col-sm-9">
                        <form:input type="text" path="lastName" id="lastName" placeholder="Last Name" class="form-control" ></form:input>
                    </div>
                </div>
                  <div class="form-group">
                    <form:label for="mobile" path="mobileNumber" class="col-sm-3 control-label">mobile</form:label>
                    <div class="col-sm-9">
                        <form:input type="mobile" path="mobileNumber" id="mobile" placeholder="mobile" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <form:label for="email" path="email" class="col-sm-3 control-label">Email</form:label>
                    <div class="col-sm-9">
                        <form:input type="email" path="email" id="email" placeholder="Email" class="form-control"></form:input>
                    </div>
                </div>
                <div class="form-group">
                    <form:label for="password" path="password" class="col-sm-3 control-label">Password</form:label>
                    <div class="col-sm-9">
                        <form:input type="password" path="password" id="password" placeholder="Password" class="form-control"></form:input>
                    </div>
                </div>
                 <div class="form-group">
                    <form:label for="confirmpassword" path="confirmPassword" class="col-sm-3 control-label">Confirm password</form:label>
                    <div class="col-sm-9">
                        <form:input type="password" path="confirmPassword" id="password" placeholder="confirmpassword" class="form-control"></form:input>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">I read <a href="#">terms and Conditions</a>
                            </label>
                        </div>
                    </div>
                </div> <!-- /.form-group -->
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-primary btn-block" onClick="submitData();">Register</button>
                    </div>
                </div>
            </form:form> <!-- /form -->
        </div> <!-- ./container -->

</body>

<!-- <script type="text/javascript" >
var firstName = $('#firstName').val(); 
var lastName = $('#lastName').val(); 
var json = {"firstName" : firstName,"lastName" : lastName}; 

function submitData(){
	$.ajax({ 
	    url: "/user/register", 
	    type: 'POST', 
	    data: JSON.stringify(json),
	    cache:false,
        beforeSend: function(xhr) {  
            xhr.setRequestHeader("Accept", "application/json");  
            xhr.setRequestHeader("Content-Type", "application/json");  
        },
        success:function(response){
            alert("Validation: "+response.validation+"   Name: "+response.name+"  Location: "+response.location);
        },
        error:function(jqXhr, textStatus, errorThrown){
            alert(textStatus);
        }
	});
	return true;
}
</script> -->
</html>