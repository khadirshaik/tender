$(function () {

      $('#addSchedule').click(function () {
    	  
    	
        var $listProduct = $('.clone');
        var $clone = $listProduct.clone();
        //$clone.find(':text').val('');
        $('.list-product-wrapper').append($clone);
        $('.list-product-wrapper .list-product').removeClass('clone');
        $('.list-product-wrapper h2').attr('style', 'display:block');
        
       
   
        
    


      })
      

   /*   $(document).on('change', '.scheduleNumberDropdown', function (e) {
          //alert("1111");
          var selectedSchedNumber = this.value;
          
          var selectedOption = $(this).find('option:selected').attr('id');
          alert("selectedOption:::"+selectedOption);
          var selectedSchedName = getSchedulerValues(selectedOption,0);
          var selectedPatientTarget = getSchedulerValues(selectedOption,1);
          //var selectedVal = $(this).find('option:selected').val();
          $(this).closest('.list-product').find('.scheduleNumber').text(selectedSchedNumber);
          $(this).parent().next('.schudule-nameDiv').find('.schedName').val(selectedSchedName);
          $(this).parent().next('.schudule-nameDiv').next('.schudule-patientDiv').find('.patTarget').val(selectedPatientTarget);
        });*/
      
       $(document).on('change', '.scheduleNumberDropdown', function (e) {
          //alert("1111");
       
         
        var selectedVal = $(this).find('option:selected').val();
		//alert("selectedVal:::"+selectedVal);
		   var selectedSchedNumber = getSchedulerValues(selectedVal,0);
       var selectedSchedName = getSchedulerValues(selectedVal,1);
          var selectedPatientTarget = getSchedulerValues(selectedVal,2);
		 // alert("selectedSchedName:::"+selectedSchedName);
          //var selectedVal = $(this).find('option:selected').val();
          $(this).closest('.list-product').find('.scheduleNumber').text(selectedSchedNumber);
          $(this).parent().next('.schudule-nameDiv').find('.schedName').val(selectedSchedName);
          $(this).parent().next('.schudule-nameDiv').next('.schudule-patientDiv').find('.patTarget').val(selectedPatientTarget);
        });
      
      commonJQuery();  
      
    });
      


    $(document).on('click', '.deleteSchedule', function () {
    	//alert("delete1:::");
      $(this).closest('.list-product').remove();
     
      //alert("delete2:::");
    })
    
     $(document).on('click', '.accordion-header', function () {
    	
        $(this).next('.panel').toggle();
        $(this).toggleClass('active')
        
      });
 
      $(document).on('click', 'a.add-btn', function (e) {
    	
        var content = jQuery('#sample_table tr'),
        element = content.clone();
        
        parentEl = $(this).closest('.tbl_posts_body')
        
        element.appendTo(parentEl);
        console.log("Click in add-btn");
        
      });
      $(document).on('click', 'a.add-btn-tb', function (e) {
      	
          var content = jQuery('#sample_table tr'),
          element = content.clone();
          
          parentEl = $(this).closest('.tbl_posts_body')
          
          element.appendTo(parentEl);
          console.log("Click in sample_tabletable");
          
        });
      
      $(document).on('click', 'a.remove-row', function () {
    	  

        $(this).closest('tr').remove();
       
      });
    


    
/* index  0-> scheduleName, 1-> patientTarget*/
function getSchedulerValues(schedValues,index){
 	return schedValues.split(',')[index];
}
    
    
    $(document).on('click', '#save', function () {
    	//alert("save");
        var schedularJson = [];
    $(".list-product-wrapper .list-product").each(function() {
    itemsArray = [];
    $(this).find(".tenderRootDiv .tenderItemTable .tbl_posts_body tr").each(function() {    
    itemsArray.push({
      tenderItemNumber: $(this).find(".tenderItem").val(),
      gdfGenericCode: $(this).find(".gdfGenCode").val(),
      generalDescripton: $(this).find(".genDesc").val(),
      primaryPackaging: $(this).find(".primPack").val(),
      secondaryPackaging: $(this).find(".secPack").val(),
    })     
    });
    schedularJson.push({
    schduleNumber: $(this).find(".scheduleNumber").text(),
    scheduleName: $(this).find(".schedName").val(),
    patientTarget: $(this).find(".patTarget").val(),
    tenderItems: itemsArray
    });
    });

    // then to get the JSON string
    var jsonString = JSON.stringify(schedularJson);
    alert(":::save jsonString"+jsonString);
    $(".completeJsonString").val(jsonString);
    });
    	
    
    
    
    
    $(document).on('click', '#update', function () {
    	//alert("update");
        var schedularJson = [];
    $(".list-product-wrapper .list-product").each(function() {
    itemsArray = [];
    $(this).find(".tenderRootDiv .tenderItemTable .tbl_posts_body tr").each(function() {     
    itemsArray.push({
      tenderItemNumber: $(this).find(".tenderItem").val(),
      gdfGenericCode: $(this).find(".gdfGenCode").val(),
      generalDescripton: $(this).find(".genDesc").val(),
      primaryPackaging: $(this).find(".primPack").val(),
      secondaryPackaging: $(this).find(".secPack").val(),
      tenderItemRefId: $(this).find(".tenderRefId").val(),
    })     
    });
    schedularJson.push({
    schduleNumber: $(this).find(".scheduleNumber").text(),
    scheduleName: $(this).find(".schedName").val(),
    patientTarget: $(this).find(".patTarget").val(),
    tenderItems: itemsArray
    });
    });

    // then to get the JSON string
    var jsonString = JSON.stringify(schedularJson);
    //alert(":::update jsonString"+jsonString);
    $(".completeJsonString").val(jsonString);
    });
    	
    

    

	//Open pop up
	function popUpOpen(popUp){
		var targeted_popup_class = popUp;
		$(
				'[data-popup="'
				+ targeted_popup_class
				+ '"]').fadeIn(350);
	}

	//close pop up
	$('[data-popup-close]').on(
			'click',
			function(e) {
				var targeted_popup_class = jQuery(this)
				.attr('data-popup-close');
				$(
						'[data-popup="'
						+ targeted_popup_class
						+ '"]').fadeOut(350);

				e.preventDefault();
			});
    
    
 
	
/*	function validateForm(url){
		//alert("validation");	
		
		var prodCategory = $("#productCategory").val(); 
		var tenderRefNumber = $("#tenderReferenceNumber").val(); 
		var title = $("#title").val(); 
		var publicationDate = $("#publicationDate").val(); 
		var deadlineForTechBidsSub = $("#deadlineForTechBidsSub").val(); 
		var tenderStatus = $("#tenderStatus").val(); 
		
		$("#productCategory").next('.error').remove();
		$("#tenderReferenceNumber").next('.error').remove();
		$("#title").next('.error').remove();
		$("#publicationDate").next('.error').remove();
		$("#deadlineForTechBidsSub").next('.error').remove();
		$("#tenderStatus").next('.error').remove();
				
		$(".successMsg").text("");
		if ($("#productCategory").val() == "" || $("#tenderReferenceNumber").val() == "" || $("#title").val() == "" || $("#publicationDate").val() == "" 
			|| $("#deadlineForTechBidsSub").val() == ""	|| $("#tenderStatus").val() == "") {
			if ($("#productCategory").val() == "") {
				$("#productCategory")
				.after(
				"<div class='error' style='color:red;'>Please enter product category</div>");
			}
			if ($("#tenderReferenceNumber").val() == "") {
				$("#tenderReferenceNumber")
				.after(
				"<div class='error' style='color:red;'>Please enter tender reference number</div>");
			}
			if ($("#title").val() == "") {
				$("#title")
				.after(
				"<div class='error' style='color:red;'>Please enter title</div>");
			}
			if ($("#publicationDate").val() == "") {
				$("#datetimepicker1")
				.after(
				"<div class='error' style='color:red;'>Please enter publication date</div>");
			}
			if ($("#deadlineForTechBidsSub").val() == "") {
				$("#datetimepicker2")
				.after(
				"<div class='error' style='color:red;'>Please enter deadline for Technical Bids submission date</div>");
			}
			if ($("#tenderStatus").val() == "") {
				$("#tenderStatus")
				.after(
				"<div class='error' style='color:red;'>Please enter status</div>");
			}
		} else{
			popUpOpen('saveTenderPopUp');
				
		}
	}
		*/
	
$(document).on('click', '#saveAnchor', function (e) {
		//alert("validation");
	var tendClass = $('div').hasClass("error");
	//alert("::tendClass has class:::"+tendClass);
		
		var prodCategory = $("#productCategory").val(); 
		var tenderRefNumber = $("#tenderReferenceNumber").val(); 
		var title = $("#title").val(); 
		var publicationDate = $("#publicationDate").val(); 
		var deadlineForTechBidsSub = $("#deadlineForTechBidsSub").val(); 
		var tenderStatus = $("#tenderStatus").val(); 
		
		//alert("::tenderRefNumber::"+tenderRefNumber+"::publicationDate:::"+publicationDate+"::deadlineForTechBidsSub:::"+deadlineForTechBidsSub);
		
		$("#productCategory").next('.error').remove();
		$("#tenderReferenceNumber").next('.error').remove();
		$("#title").next('.error').remove();
		$("#datetimepicker1").next('.error').remove();
		$("#datetimepicker2").next('.error').remove();
		$("#tenderStatus").next('.error').remove();
				
		$(".successMsg").text("");
		if ($("#productCategory").val() == "" || $("#tenderReferenceNumber").val() == "" || $("#title").val() == "" || $("#publicationDate").val() == "" 
			|| $("#deadlineForTechBidsSub").val() == ""	|| $("#tenderStatus").val() == "") {
			if ($("#productCategory").val() == "") {
				$("#productCategory")
				.after(
				"<div class='error' style='color:red;'>Please enter product category</div>");
			}
			if ($("#tenderReferenceNumber").val() == "") {
				$("#tenderReferenceNumber")
				.after(
				"<div class='error' style='color:red;'>Please enter tender reference number</div>");
			}
			if ($("#title").val() == "") {
				$("#title")
				.after(
				"<div class='error' style='color:red;'>Please enter title</div>");
			}
			if ($("#publicationDate").val() == "") {
				$("#datetimepicker1")
				.after(
				"<div class='error' style='color:red;'>Please enter publication date</div>");
			}
			if ($("#deadlineForTechBidsSub").val() == "") {
				$("#datetimepicker2")
				.after(
				"<div class='error' style='color:red;'>Please enter deadline for Technical Bids submission date</div>");
			}
			if ($("#tenderStatus").val() == "") {
				$("#tenderStatus")
				.after(
				"<div class='error' style='color:red;'>Please enter status</div>");
			}
			 
		}else{
			if(tendClass){
				 //alert("validation::"+tendClass);
					
					//event.preventDefault();
					//return false;
				e.stopImmediatePropagation();
				} else {
					popUpOpen('saveTenderPopUp');
				}
		}
	});
	
	
	function commonJQuery(){
		//Start of code to allow 60 as a max value for shelf life
		$('#tenderItemNumber').on('input', function () {
			var value = $(this).val();
			if ((value !== '') && (value.indexOf('.') === -1)) {
				$(this).val(Math.max(Math.min(value, 60), 0));
			}
		});
		//end of code to allow 60 as a max value for shelf life

		
		//Start of code to restrict invalid character in input type number
		var inputBox = $('input[type=number]');
		var invalidChars = [
			"1",
			"2",
			"3",
			"4",
			"5",
			"6",
			"7",
			"8",
			"9",
			"0"
			];
		inputBox.keypress(function(e) {
			if (!invalidChars.includes(e.key)) {
				e.preventDefault();
			}
		});
		//End of code to restrict invalid character in input type number

		//Start of code To show value of input fields on hover
		$('input').hover(function(){
			var titleTxt = $(this).val(); 
			$(this).attr('title', titleTxt );
		});
		//End of code To show value of input fields on hover

		//Start of code To avoid copy paste for type numeric fields
		$('input[type=number]').on('paste', function (event) {
			var data = event.originalEvent.clipboardData.getData('Text');
			if(data >= 0) {
				if(data.indexOf('.') != -1){
					event.preventDefault();
				}
			}
			else {
				event.preventDefault();}
		}) ;
		//End of code To avoid copy paste for type numeric fields

	}

	
	/*$(document).on('change', '#productCategory', function () {
        
        var productCategory = this.value;
        alert("productCategory:::"+productCategory);
        
        $('#productCatChanged').val(productCategory);
   
    
  });*/

	
	$(document).on('change paste keyup', '.list-product-wrapper .list-product .tenderRootDiv .tenderItemTable .tbl_posts_body tr #tenderItemNumber', function () {
		$(this).next('.error').remove();
		var currentVal= $(this).val();
		var tBody= $(this).closest('.tbl_posts_body');
		    var totalLength = tBody.find('tr').length;
		    //alert("current totalLength::"+totalLength+ "::::currentVal::"+currentVal);
			var itemsArray = [];
			
			 tBody.find("tr").each(function() {    
			 var itemNumber = $(this).find('#tenderItemNumber').val();
			 if($.trim(itemNumber).length >0){
			 itemsArray.push(itemNumber);
			 }
			 });
		   
	
		   
		
	 var sorted_arr = itemsArray.sort(); 
		    //alert("browser sorted_arr::"+sorted_arr);
		    var results = [];
		    for (var i = 0; i < itemsArray.length - 1; i++) {
		        if (sorted_arr[i + 1] == sorted_arr[i]) {
		            results.push(sorted_arr[i]);
		           
															
		    }
		   
		    }
			if(results.length >0){
			$(this).after("<div class='error' style='color:red;'>Duplicate number</div>");
			//alert("Duplicate item number::"+results);
			}else {
				$(this).next('.error').remove();
				 tBody.find("tr").each(function() {  
				// alert("broswer Duplicate item number in ifelse::"+$(this).find('#tenderItemNumber').val());
				$(this).find('#tenderItemNumber').next('.error').remove();
				});
				}
			
		});
		
		
	
	$(document).on('change', '.list-product-wrapper .list-product .tenderRootDiv .tenderItemTable .tbl_posts_body tr #gdfGenericCode', function () {
		$(this).next('.error').remove();
		var currentVal= $(this).val();
		var tBody= $(this).closest('.tbl_posts_body');
		    var totalLength = tBody.find('tr').length;
		   // alert("current totalLength::"+totalLength+ "::::currentVal::"+currentVal);
			var itemsArray = [];
			
			 tBody.find("tr").each(function() {    
			 var genCode = $(this).find('#gdfGenericCode').val();
			 if($.trim(genCode).length >0){
			 itemsArray.push(genCode);
			 }
			 });
		   
		
		   
		
	 var sorted_arr = itemsArray.sort(); 
		   // alert("browser sorted_arr::"+sorted_arr);
		    var results = [];
		    for (var i = 0; i < itemsArray.length - 1; i++) {
		        if (sorted_arr[i + 1] == sorted_arr[i]) {
		            results.push(sorted_arr[i]);
		           
															
		    }
		   
		    }
			if(results.length >0){
			$(this).after("<div class='error' style='color:red;'>Duplicate generic code</div>");
			//alert("Duplicate generic code::"+results);
			}else {
				$(this).next('.error').remove();
				 tBody.find("tr").each(function() {  
				 //alert("broswer Duplicate gdfGenericCode in ifelse::"+$(this).find('#tenderItemNumber').val());
				$(this).find('#gdfGenericCode').next('.error').remove();
				});
				}
			
		});
		
	
	// For 1st tab
	function tenderSchedNoList(data) {

		// alert(data);
		var optionArray = [];
		 const jsonData = JSON.parse(data);

			var scedList = jsonData.scheduleJsonArray;
			
	        $('.list-product-wrapper .list-product .form-group #scheduleNumber').empty();
	        $('.list-product-wrapper .list-product .form-group #scheduleNumber').append('<option value="">Select</option>');
	        $('.clone .form-group #scheduleNumber').empty();
	        $('.clone .form-group #scheduleNumber').append('<option value="">Select</option>');
			$.each(scedList, function(key, value) {
				
				var scheduleNo = value.scheduleNumber;
				var schedName = value.scheduleName;
				var patTarget = value.patientTarget;
				
		
				var option = "<option value='" + scheduleNo + "," + schedName + "," + patTarget + "'>" + scheduleNo + "</option>";
				optionArray.push(option);
			
			});
			
			
			//alert("optionArray::::"+optionArray);
		
			$.each(optionArray, function(key,value) {    
				
		//alert("::value::"+value);
		$('.clone .form-group #scheduleNumber').append(value);
		 $('.list-product-wrapper .list-product .form-group #scheduleNumber').append(value);
			});
	}
	
// for schedule number drop down
function fetchScheduleNosAjax(ajaxUrl) {
		var productCatVal = $("#productCategory").val();
		// alert(":::productCatVal:::"+productCatVal);
		var url = ajaxUrl;
		$("#loaderWrap").show();
		var data = {
				productCatVal : productCatVal
		};
		
		jQuery.post(url, data, function(data) {
			
			tenderSchedNoList(data);
			setTimeout(function() {
				$("#loaderWrap").hide();
			}, 1500);
		});
	}

$(document).on('click', '#tenderRefNum', function() {

	//alert("hello");
	var tenderStatus = $(this).siblings('.sorting_1').text();

	//alert("browser tenderStatus:::" + tenderStatus);
	
	if(tenderStatus == "Active"){
		//alert("hello");
		$(".row .col-sm-4 form-group #title").prop("disabled", true);
	}

	
	});

		
