/*$(document).ready(
		function() {
			// alert("ready");

			
 * var activeTabLabel = $("#topNavTabs li.active a
 * span.titleDot").text(); $('.labelt').text(activeTabLabel);
 * 
 * $('.btn-nxt').click(function () { $( ".sel" ).each(function(
 * index ) { if($(this).val() == 0) {
 * $(this).next('span.emptySelect').css('display',"block") } else{
 * $(this).next('span.emptySelect').css('display',"none") } });
 * 
 * }); $('.btn-previous').click(function () { $('.nav-tabs >
 * .active').prev('li').find('a').trigger('click'); var
 * activeTabLabel = $("#topNavTabs li.active a
 * span.titleDot").text(); $('.labelt').text(activeTabLabel); });
			 

			var activeTabLabel = $("#topNavTabs  li.active a span.titleDot")
					.text();
			$('.labelt').text(activeTabLabel);

			$('.btn-nxt').click(
					function() {

						$(".sel").each(
								function(index) {
									alert("Next");
									if ($(this).val() == 0) {
										$(this).next('span.emptySelect').css(
												'display', "block")
									} else {
										$(this).next('span.emptySelect').css(
												'display', "none")
									}
								});
						if (this.id = "nextBtnTab1") {
							//alert("not next");
							nextTab();
						}
					});
			
			$('.btn-nxt').click(
					function() {
						
						nextTab();
					});

			$('.btn-previous').click(
					function() {
						alert("previous");
						$('.nav-tabs > .active').prev('li').find('a').trigger(
								'click');
						var activeTabLabel = $(
								"#topNavTabs  li.active a span.titleDot")
								.text();
						$('.labelt').text(activeTabLabel);
					});

			 issue of btn :visited 

			$('#topNavTabs.nav-tabs li a').click(function() {
				//alert("enter");
				//$(".enterpressed").remove();
				$(this).removeClass('isDisabled');
			})
		});

function nextTab() {
	//alert("NextTab");
	$('.nav-tabs > .active').next('li').find('a').trigger('click');
	var activeTabLabel = $("#topNavTabs  li.active a span.titleDot").text();
	$('.labelt').text(activeTabLabel);
	$('.nav-tabs > .active').prev('li').find('a').css("background", "#5f366e");
	$('.nav-tabs > .active').prev('li').find('a').removeClass('isDisabled');
}*/

$(document).ready(
		function() {

			// alert("toggle");
			$('#topNavTabs.nav-tabs li a').click(function() {
				// $(".enterpressed").remove();
				$(this).removeClass('isDisabled');
			})

			// for next button
			$('.btn-nxt').click(function() {

				nextTab();

			});

			// for previous button
			$('.btn-previous').click(
					function() {
						$('.nav-tabs > .active').prev('li').find('a').trigger(
								'click');
						var activeTabLabel = $(
								"#topNavTabs  li.active a span.titleDot")
								.text();
						$('.labelt').text(activeTabLabel);
					});

			$('#nameChoosen').attr('required', false);

		});

/*
 * $(document).ready(function () {
 * 
 * $('input[type="file"].uploadFile').change(function (e) {
 * $(this).siblings('input[type="text"]').val(e.target.files[0].name); });
 * 
 * 
 * });
 */

function nextTab() {
	// to change between the tabs
	$('.nav-tabs > .active').next('li').find('a').trigger('click');
	var activeTabLabel = $("#topNavTabs  li.active a span.titleDot").text();
	$('.labelt').text(activeTabLabel);

	$('.nav-tabs > .active').prev('li').find('a').css("background", "#5f366e");

	$('.nav-tabs > .active').prev('li').find('a').removeClass('isDisabled');
}

$(document).on('click', '.btn-previous', function() {
	$(".btn-nxt").attr("disabled", false);

});

function enableTooltip() {
	$(".btn-nxt").attr("disabled", true);
	$(".changedFieldValidation").remove();
	$("input,select,textarea,span")
			.change(
					function() {
						// if (this.id != "postalAddress") {
						$(".changedFieldValidation").remove();
						$(".btn-nxt").attr("disabled", true);
						$(".btn-nxt")
								.parent()
								.after(
										'<p class="changedFieldValidation" style="color: red;">Please save the page before moving to the next page</p>');

						$("#tabNext")
								.parent()
								.after(
										'<p class="changedFieldValidation" style="color: red;">Please save the page before moving to the next page</p>');
						// }
					});
}

function disableToolTip() {
	$(".btn-nxt").attr("disabled", false);
	$("#tabNext").attr("disabled", false);
}

// For 1st tab
function tenderRefDetails(data) {

	// alert(data);

	var jsonData = JSON.parse(data);

	/*
	 * $('.tender-submission-container #productCategory
	 * #productCategoryVal').val(
	 * jsonData.ProdCategory).text(jsonData.ProdCategory);
	 */
	$('.tender-submission-container #productCategoryVal').val(
			jsonData.ProdCategory);
	$('.tender-submission-container #title').val(jsonData.Title);
	$('.tender-submission-container #publicationDate').val(
			jsonData.PublicationDate);
	$('.tender-submission-container #deadlineForTechBidsSub').val(
			jsonData.DeadlineForTechBidsSub);
	$('.tender-submission-container #method').text(jsonData.Method);

}

// For 1st tab
function tenderSchedList(data) {

	const jsonData = JSON.parse(data);

	var scedList = jsonData.scheduleJsonArray;

	if (scedList.length == 0) {
		$('.list-product-wrapper').empty();
		console.log("NO DATA!")
		$('.list-product-wrapper')
				.append(
						'<h2 style="text-align: center; color: red !important;">No Schedules are avilable for this tender!!!</h2>')
	} else {
		$('.list-product-wrapper').empty();
		$('.list-product-wrapper').append(
				'<h2>List of products per schedule</h2>');
	}

	$.each(scedList, function(key, value) {

		// clone schedule div and populate data
		var tenderItems = value.tenderItemDetailsModelList;
		var sechdProdList = $('.clone1');

		var scheduleClone = sechdProdList.clone();

		$.each(tenderItems,
				function(itemkey, itemValue) {

					var tendTrList = $('.clone2');
					var tenderClone = tendTrList.clone();

					scheduleClone.find('.accordion-header #schedNum').text(
							value.scheduleNumber);
					tenderClone.find('#schedName').val(value.scheduleName);
					tenderClone.find('#patTarget').val(value.patientTarget);

					tenderClone.find('#tendItem').val(
							itemValue.tenderItemNumber);
					tenderClone.find('#gdfGenCode').val(
							itemValue.gdfGenericCode);

					tenderClone.find('#tenderItemRefId').val(
							itemValue.tenderItemRefId);

					scheduleClone.find('.tbl_posts_body').append(tenderClone);
					scheduleClone.find('.tenderItemsData')
							.removeClass('clone2');
				});

		// For 1st tab

		$('.list-product-wrapper').append(scheduleClone);
		$('.list-product-wrapper .list-product').removeClass('clone1');
		$('.list-product-wrapper .list-product .panel').attr('style',
				'display:none');

		$('.list-product-wrapper .list-product .accordion-header').first()
				.addClass('accordion-active');
		$('.list-product-wrapper .list-product .panel').first().attr('style',
				'display:block');

	});

}

// for tenderReference number drop down
function fetchTenderRefNumAjax(ajaxUrl, namespace) {
	var tenderRefNo = $("#tenderReferenceNumber").val();
	var url = ajaxUrl;
	$("#loaderWrap").show();
	var data = {
		tenderRefNo : tenderRefNo
	};
	// alert(data);
	jQuery.post(url, data, function(data) {
		tenderRefDetails(data);
		tenderSchedList(data);
		enableTooltip();
		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 1500);
	});
}

// save selectGdfTender Ajax call

function saveSelGdfTender(ajaxUrl, namespace) {

	$("#loaderWrap").show();

	var tenderRefNo = $("#tenderReferenceNumber").val();
	var productCategoryVal = $("#productCategoryVal").val();
	var title = $("#title").val();
	var publicationDate = $("#publicationDate").val();
	var deadlineForTechBidsSub = $("#deadlineForTechBidsSub").val();
	var method = $("#method").text();
	var tenderSubRefId = $("#tenderSubRefId").val();

	var schedularJson = [];
	$(".list-product-wrapper .list-product").each(
			function() {
				itemsArray = [];
				$(this).find(
						".tenderRootDiv .tenderItemTable .tbl_posts_body tr")
						.each(
								function() {
									itemsArray.push({
										tenderItemNumber : $(this).find(
												"#tendItem").val(),
										gdfGenericCode : $(this).find(
												"#gdfGenCode").val(),
										tenderItemRefId : $(this).find(
												"#tenderItemRefId").val(),
									})
								});
				schedularJson.push({
					schduleNumber : $(this).find("#schedNum").text(),
					scheduleName : $(this).find("#schedName").val(),
					patientTarget : $(this).find("#patTarget").val(),
					tenderItems : itemsArray
				});
			});

	var jsonInput = {
		tenderRefNo : tenderRefNo,
		productCategoryVal : productCategoryVal,
		title : title,
		publicationDate : publicationDate,
		deadlineForTechBidsSub : deadlineForTechBidsSub,
		method : method,
		tenderSubRefId : tenderSubRefId,
		selGdfTenderArr : schedularJson
	};

	// alert(":::jsonInput:::" + jsonInput);
	var url = ajaxUrl;

	var data = {
		"requestData" : JSON.stringify(jsonInput)
	};

	jQuery.post(url, data, function(data) {

		var response = JSON.stringify(eval("(" + data + ")"));
		// alert(":::response:::" + response);
		var json = JSON.parse(response);
		// alert(":::json:::" + json);

		$('.adhocinfo').empty()
		$('.adhocinfo').append(html);

	});
	// $('.nextBtnTab1').attr("disabled", false);
	// $('#tabNext').attr("disabled", false);
	disableToolTip();
	setTimeout(function() {
		$("#loaderWrap").hide();
	}, 2000);
}

// edit selectGdfTender Ajax call

function editSelGdfTender(ajaxUrl, namespace) {

	$("#loaderWrap").show();

	var tenderRefNo = $("#tenderReferenceNumber").val();
	var productCategoryVal = $("#productCategoryVal").val();
	var title = $("#title").val();
	var publicationDate = $("#publicationDate").val();
	var deadlineForTechBidsSub = $("#deadlineForTechBidsSub").val();
	var method = $("#method").text();
	var tenderSubRefId = $("#tenderSubRefId").val();

	var schedularJson = [];
	$(".list-product-wrapper .list-product").each(
			function() {
				itemsArray = [];
				$(this).find(
						".tenderRootDiv .tenderItemTable .tbl_posts_body tr")
						.each(
								function() {
									itemsArray.push({
										tenderItemNumber : $(this).find(
												"#tendItem").val(),
										gdfGenericCode : $(this).find(
												"#gdfGenCode").val(),
										tenderItemRefId : $(this).find(
												"#tenderItemRefId").val(),
									})
								});
				schedularJson.push({
					schduleNumber : $(this).find("#schedNum").text(),
					scheduleName : $(this).find("#schedName").val(),
					patientTarget : $(this).find("#patTarget").val(),
					tenderItems : itemsArray
				});
			});

	var jsonInput = {
		tenderRefNo : tenderRefNo,
		productCategoryVal : productCategoryVal,
		title : title,
		publicationDate : publicationDate,
		deadlineForTechBidsSub : deadlineForTechBidsSub,
		method : method,
		tenderSubRefId : tenderSubRefId,
		selGdfTenderArr : schedularJson
	};

	// alert(":::jsonInput:::" + jsonInput);
	var url = ajaxUrl;

	var data = {
		"requestData" : JSON.stringify(jsonInput)
	};

	jQuery.post(url, data, function(data) {

		var response = JSON.stringify(eval("(" + data + ")"));
		// alert(":::response:::" + response);
		var json = JSON.parse(response);
		// alert(":::json:::" + json);

		$('.adhocinfo').empty()
		$('.adhocinfo').append(html);

	});
	// $('.nextBtnTab1').attr("disabled", false);
	// $('#tabNext').attr("disabled", false);
	// disableToolTip();
	setTimeout(function() {
		$("#loaderWrap").hide();
	}, 2000);
}

// For 2nd tab
function prodSelection(data) {

	const jsonData = JSON.parse(data);

	var tenderRefNo = $("#tenderReferenceNumber").val();
	$(
			'.tender-submission-container .text-note .ref-num-note #tenderReferenceNumber')
			.text(tenderRefNo);

	var scedList = jsonData.schedFppMartJsonArray;

	if (scedList.length == 0) {
		$('.select-product-wrapper').empty();
		console.log("NO DATA!")
		$('.select-product-wrapper')
				.append(
						'<h2 style="text-align: center; color: red !important;">No Schedules are avilable for this tender!!!</h2>')
	} else {
		$('.select-product-wrapper').empty();
		$('.select-product-wrapper').append(
				'<h2>List of products per schedule</h2>');
	}

	$
			.each(
					scedList,
					function(key, value) {

						// clone schedule div and populate data
						var tenderItems = value.fppMartModelList;
						var sechdProdList = $('.prodclone');

						var scheduleClone = sechdProdList.clone();
						if (!(jQuery.isEmptyObject(tenderItems))) {

							$.each(tenderItems, function(itemkey, itemValue) {

								var tendTrList = $('.prodTableclone');
								var tenderClone = tendTrList.clone();

								scheduleClone.find(
										'.accordion-header #schedNum').text(
										value.scheduleNumber);

								tenderClone.find('#tendItem').val(
										itemValue.tenderItemNumber);
								tenderClone.find('#gdfGenCode').text(
										itemValue.gdfGenericCode);
								tenderClone
								.find('#gdfGenCode').attr('href','/web/guest/fppinmarket/edit?fppMarketId='+itemValue.fppMarketId);

								tenderClone.find('#dosageForm').val(
										itemValue.dosageForm);
								tenderClone.find('#noOfUnitsForPrimPack').val(
										itemValue.noOfPrimaryPackaging);
								tenderClone.find('#noOfUnitsForSecPack').val(
										itemValue.noOfSecondaryPackaging);
								tenderClone.find('#fppMarStauts').val(
										itemValue.fppMartStatus);
								tenderClone.find('#tenderFPPMatRefNumber').val(
										itemValue.tenderFPPMatRefNumber);
								tenderClone.find('#fppMarketId').val(
										itemValue.fppMarketId);
								tenderClone.find('#tenderReferenceNumber').val(
										itemValue.tenderReferenceNumber);

								// scheduleClone.find('.tenderItemsData').val('').remove();
								scheduleClone.find('.tbl_posts_body').append(
										tenderClone);
								scheduleClone.find('.tenderItemsData')
										.removeClass('prodTableclone');

							});

							// For 2nd tab

							$('.select-product-wrapper').append(scheduleClone);
							$('.select-product-wrapper .list-product')
									.removeClass('prodclone');
							$('.select-product-wrapper .list-product .panel')
									.attr('style', 'display:none');

							$(
									'.select-product-wrapper .list-product .accordion-header')
									.first().addClass('accordion-active');
							$('.select-product-wrapper .list-product .panel')
									.first().attr('style', 'display:block');
						}
					});

}

// for 2nd tab Select FPP Market
function fetchSelectGdfTenders(ajaxUrl) {
	var tenderRefNo = $("#tenderReferenceNumber").val();
	var url = ajaxUrl;
	$("#loaderWrap").show();
	var data = {
		tenderRefNo : tenderRefNo
	};
	// alert(data);
	jQuery.post(url, data, function(data) {
		prodSelection(data);
		enableTooltip();
		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 1500);
	});
}

// for check box selection

/*
 * $(document).on('click', '#fppSelTenderSub', function() { alert("In check
 * function"); if ($(this).is(':checked')) { $(this).attr('value', 'true'); }
 * else { $(this).attr('value', 'false'); }
 * 
 * });
 */

// Open pop up
function popUpOpen(popUp) {
	var targeted_popup_class = popUp;
	$('[data-popup="' + targeted_popup_class + '"]').fadeIn(350);
}

// close pop up
$('[data-popup-close]').on('click', function(e) {
	var targeted_popup_class = jQuery(this).attr('data-popup-close');
	$('[data-popup="' + targeted_popup_class + '"]').fadeOut(350);

	e.preventDefault();
});

$(document).on('click', '#tabNext', function() {
	$(".changedFieldValidation").remove();
	popUpOpen('tenderNextPopUp');

});

$(document).on('click', '#fppSelTenderSub', function() {

	var currentRow = $(this).closest("tr");
	var fppAppStatus = currentRow.find("#fppMarStauts").val();
	// alert("fppAppStatus::::"+fppAppStatus);

	if ($(this).is(':checked')) {
		$(this).attr('value', 'true');
		if (fppAppStatus == "Approved") {
			// alert("This product is eligible!!!");
			$(this).prop('checked', true);
			$(this).attr('value', 'true');
		} else if (fppAppStatus == "Pending" || fppAppStatus == "Draft") {

			popUpOpen('saveTenderPopUp');

			$(this).prop('checked', false);
			$(this).attr('value', 'false');
		}
	} else {
		$(this).attr('value', 'false');
	}

});

// save product Selection tab ajax call

function savePrdSelection(ajaxUrl) {

	$("#loaderWrap").show();

	var tenderRefNo = $("#tenderReferenceNumber").val();

	var schedularJson = [];
	$(".select-product-wrapper .list-product")
			.each(
					function() {
						itemsArray = [];
						$(this)
								.find(
										".tenderRootDiv .tenderItemTable .tbl_posts_body tr")
								.each(
										function() {

											itemsArray
													.push({
														tenderReferenceNumber : $(
																this)
																.find(
																		"#tenderReferenceNumber")
																.val(),
														gdfGenericCode : $(this)
																.find(
																		"#gdfGenCode")
																.val(),
														dosageForm : $(this)
																.find(
																		"#dosageForm")
																.val(),
														noOfUnitsForPrimPack : $(
																this)
																.find(
																		"#noOfUnitsForPrimPack")
																.val(),
														noOfUnitsForSecPack : $(
																this)
																.find(
																		"#noOfUnitsForSecPack")
																.val(),
														fppMarStauts : $(this)
																.find(
																		"#fppMarStauts")
																.val(),
														fppSelTenderSub : $(
																this)
																.find(
																		'#fppSelTenderSub')
																.val(),
														fppMarketId : $(this)
																.find(
																		"#fppMarketId")
																.val(),
														tenderItemNumber : $(
																this).find(
																"#tendItem")
																.val(),

													})

										});

						schedularJson.push({
							schduleNumber : $(this).find("#schedNum").text(),
							tenderItems : itemsArray
						});

					});

	// alert(":::schedularJson:::" + schedularJson);
	var jsonInput = {
		tenderRefNo : tenderRefNo,
		selPrdSelArr : schedularJson
	};

	// alert(":::jsonInput:::" + jsonInput);
	var url = ajaxUrl;

	var data = {
		"requestData" : JSON.stringify(jsonInput)
	};

	jQuery.post(url, data, function(data) {

		var response = JSON.stringify(eval("(" + data + ")"));
		// alert(":::response:::" + response);
		var json = JSON.parse(response);
		// alert(":::json:::" + json);

		$('.adhocinfo').empty()
		$('.adhocinfo').append(html);

	});

	// $('.nextBtnTab1').attr("disabled", false);
	disableToolTip();
	setTimeout(function() {
		$("#loaderWrap").hide();
	}, 2000);
}

// edit product Selection tab ajax call

function editPrdSelection(ajaxUrl) {

	$("#loaderWrap").show();

	var tenderRefNo = $("#tenderReferenceNumber").val();

	var schedularJson = [];
	$(".select-product-wrapper .list-product")
			.each(
					function() {
						itemsArray = [];
						$(this)
								.find(
										".tenderRootDiv .tenderItemTable .tbl_posts_body tr")
								.each(
										function() {

											itemsArray
													.push({
														tenderReferenceNumber : $(
																this)
																.find(
																		"#tenderReferenceNumber")
																.val(),
														gdfGenericCode : $(this)
																.find(
																		"#gdfGenCode")
																.val(),
														dosageForm : $(this)
																.find(
																		"#dosageForm")
																.val(),
														noOfUnitsForPrimPack : $(
																this)
																.find(
																		"#noOfUnitsForPrimPack")
																.val(),
														noOfUnitsForSecPack : $(
																this)
																.find(
																		"#noOfUnitsForSecPack")
																.val(),
														fppMarStauts : $(this)
																.find(
																		"#fppMarStauts")
																.val(),
														fppSelTenderSub : $(
																this)
																.find(
																		'#fppSelTenderSub')
																.val(),
														fppMarketId : $(this)
																.find(
																		"#fppMarketId")
																.val(),
														tenderItemNumber : $(
																this).find(
																"#tendItem")
																.val(),

													})

										});

						schedularJson.push({
							schduleNumber : $(this).find("#schedNum").text(),
							tenderItems : itemsArray
						});

					});

	// alert(":::schedularJson:::" + schedularJson);
	var jsonInput = {
		tenderRefNo : tenderRefNo,
		selPrdSelArr : schedularJson
	};

	// alert(":::jsonInput:::" + jsonInput);
	var url = ajaxUrl;

	var data = {
		"requestData" : JSON.stringify(jsonInput)
	};

	jQuery.post(url, data, function(data) {

		var response = JSON.stringify(eval("(" + data + ")"));
		// alert(":::response:::" + response);
		var json = JSON.parse(response);
		// alert(":::json:::" + json);

		$('.adhocinfo').empty()
		$('.adhocinfo').append(html);

	});

	// $('.nextBtnTab1').attr("disabled", false);
	// disableToolTip();
	setTimeout(function() {
		$("#loaderWrap").hide();
	}, 2000);
}

// For already selected tab3

function alreadySelectedProd(data) {

	const jsonData = JSON.parse(data);
	// alert(":::jsonData:::" + jsonData);
	var submittedStatus = $("#tenderSubmissionStatus").val();

	var tenderStatus = $("#tenderDetailsStatus").val();
	// alert(":::tenderStatus:::"+tenderStatus);
	$('#tenderSubmissionStatus').val(submittedStatus);
	$('#tenderDetailsStatus').val(tenderStatus);
	var scedList = jsonData.prdSelectedJsonArray;

	if (scedList.length == 0) {
		$('.alreadySelected-product-wrapper').empty();
		console.log("NO DATA!")
		$('.alreadySelected-product-wrapper')
				.append(
						'<h2 style="text-align: center; color: red !important;">No Products have been selected for this tender!!!</h2>')
	} else {
		$('.alreadySelected-product-wrapper').empty();
		$('.alreadySelected-product-wrapper').append(
				'<h2>List of products per schedule</h2>');
	}

	$
			.each(
					scedList,
					function(key, value) {

						// clone schedule div and populate data
						var tenderItems = value.fppMartModelList;
						var sechdProdList = $('.selectedProdclone');

						var scheduleClone = sechdProdList.clone();
						if (!(jQuery.isEmptyObject(tenderItems))) {

							$
									.each(
											tenderItems,
											function(itemkey, itemValue) {

												$(
														'.tender-submission-container .text-note .ref-num-note #tenderReferenceNumber')
														.text(
																itemValue.tenderReferenceNumber);

												var tendTrList = $('.selectedProdTableclone');
												var tenderClone = tendTrList
														.clone();

												scheduleClone
														.find(
																'.accordion-header #schedNum')
														.text(
																value.scheduleNumber);
												tenderClone
														.find('#tendItem')
														.val(
																itemValue.tenderItemNumber);
												tenderClone
														.find('#gdfGenCode')
														.val(
																itemValue.gdfGenericCode);

												tenderClone
														.find('#dosageForm')
														.val(
																itemValue.dosageForm);
												tenderClone
														.find(
																'#noOfUnitsForPrimPack')
														.val(
																itemValue.noOfPrimaryPackaging);
												tenderClone
														.find(
																'#noOfUnitsForSecPack')
														.val(
																itemValue.noOfSecondaryPackaging);
												tenderClone
														.find('#fppMarStauts')
														.val(
																itemValue.fppMartStatus);
												tenderClone
														.find(
																'#tenderFPPMatRefNumber')
														.val(
																itemValue.tenderFPPMatRefNumber);
												tenderClone
														.find('#fppMarketId')
														.val(
																itemValue.fppMarketId);

												scheduleClone.find(
														'.tbl_posts_body')
														.append(tenderClone);
												scheduleClone
														.find(
																'.tenderItemsData')
														.removeClass(
																'selectedProdTableclone');

											});

							$('.alreadySelected-product-wrapper').append(
									scheduleClone);
							$('.alreadySelected-product-wrapper .list-product')
									.removeClass('selectedProdclone');
							$(
									'.alreadySelected-product-wrapper .list-product .panel')
									.attr('style', 'display:none');

							$(
									'.alreadySelected-product-wrapper .list-product .accordion-header')
									.first().addClass('accordion-active');
							$(
									'.alreadySelected-product-wrapper .list-product .panel')
									.first().attr('style', 'display:block');

						}

					});

}

// For product seclected tab 3
function prdSelectedNext(ajaxUrl) {
	var tenderRefNo = $("#tenderReferenceNumber").val();
	var url = ajaxUrl;
	$("#loaderWrap").show();
	var data = {
		tenderRefNo : tenderRefNo
	};
	// alert(data);
	jQuery.post(url, data, function(data) {
		alreadySelectedProd(data);
		enableTooltip();
		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 1500);
	});
}

// For edit product seclected tab 3
function updatePrdSelectedNext(ajaxUrl) {
	var tenderRefNo = $("#tenderReferenceNumber").val();
	var url = ajaxUrl;
	$("#loaderWrap").show();
	var data = {
		tenderRefNo : tenderRefNo
	};
	// alert(data);
	jQuery.post(url, data, function(data) {
		alreadySelectedProd(data);
		// enableTooltip();
		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 1500);
	});
}

// save already selected products tab3 ajax call

function alreadySelectedProducts(ajaxUrl) {

	$("#loaderWrap").show();

	var tenderRefNo = $("#tenderReferenceNumber").val();

	var schedularJson = [];
	$(".alreadySelected-product-wrapper .list-product")
			.each(
					function() {
						itemsArray = [];
						$(this)
								.find(
										".tenderRootDiv .tenderItemTable .tbl_posts_body tr")
								.each(
										function() {

											itemsArray
													.push({
														tenderItemNumber : $(
																this).find(
																"#tendItem")
																.val(),
														gdfGenericCode : $(this)
																.find(
																		"#gdfGenCode")
																.val(),
														dosageForm : $(this)
																.find(
																		"#dosageForm")
																.val(),
														noOfUnitsForPrimPack : $(
																this)
																.find(
																		"#noOfUnitsForPrimPack")
																.val(),
														noOfUnitsForSecPack : $(
																this)
																.find(
																		"#noOfUnitsForSecPack")
																.val(),
														fppMarStauts : $(this)
																.find(
																		"#fppMarStauts")
																.val(),
														tenderFPPMatRefNumber : $(
																this)
																.find(
																		"#tenderFPPMatRefNumber")
																.val(),
														fppMarketId : $(this)
																.find(
																		"#fppMarketId")
																.val(),
													})

										});

						schedularJson.push({
							schduleNumber : $(this).find("#schedNum").text(),
							tenderItems : itemsArray
						});

					});

	// alert(":::schedularJson:::" + schedularJson);
	var jsonInput = {
		tenderRefNo : tenderRefNo,
		selectedPrdArr : schedularJson
	};

	// alert(":::jsonInput:::" + jsonInput);
	var url = ajaxUrl;

	var data = {
		"requestData" : JSON.stringify(jsonInput)
	};

	jQuery.post(url, data, function(data) {

		var response = JSON.stringify(eval("(" + data + ")"));
		// alert(":::response:::" + response);
		var json = JSON.parse(response);
		// alert(":::json:::" + json);

		$('.adhocinfo').empty()
		$('.adhocinfo').append(html);

	});

	// $('.nextBtnTab1').attr("disabled", false);
	disableToolTip();
	setTimeout(function() {
		$("#loaderWrap").hide();
	}, 2000);
}

// edit already selected products tab3 ajax call

function editAlreadySelectedProducts(ajaxUrl) {

	$("#loaderWrap").show();

	var tenderRefNo = $("#tenderReferenceNumber").val();

	var schedularJson = [];
	$(".alreadySelected-product-wrapper .list-product")
			.each(
					function() {
						itemsArray = [];
						$(this)
								.find(
										".tenderRootDiv .tenderItemTable .tbl_posts_body tr")
								.each(
										function() {

											itemsArray
													.push({
														tenderItemNumber : $(
																this).find(
																"#tendItem")
																.val(),
														gdfGenericCode : $(this)
																.find(
																		"#gdfGenCode")
																.val(),
														dosageForm : $(this)
																.find(
																		"#dosageForm")
																.val(),
														noOfUnitsForPrimPack : $(
																this)
																.find(
																		"#noOfUnitsForPrimPack")
																.val(),
														noOfUnitsForSecPack : $(
																this)
																.find(
																		"#noOfUnitsForSecPack")
																.val(),
														fppMarStauts : $(this)
																.find(
																		"#fppMarStauts")
																.val(),
														tenderFPPMatRefNumber : $(
																this)
																.find(
																		"#tenderFPPMatRefNumber")
																.val(),
														fppMarketId : $(this)
																.find(
																		"#fppMarketId")
																.val(),
													})

										});

						schedularJson.push({
							schduleNumber : $(this).find("#schedNum").text(),
							tenderItems : itemsArray
						});

					});

	// alert(":::schedularJson:::" + schedularJson);
	var jsonInput = {
		tenderRefNo : tenderRefNo,
		selectedPrdArr : schedularJson
	};

	// alert(":::jsonInput:::" + jsonInput);
	var url = ajaxUrl;

	var data = {
		"requestData" : JSON.stringify(jsonInput)
	};

	jQuery.post(url, data, function(data) {

		var response = JSON.stringify(eval("(" + data + ")"));
		// alert(":::response:::" + response);
		var json = JSON.parse(response);
		// alert(":::json:::" + json);

		$('.adhocinfo').empty()
		$('.adhocinfo').append(html);

	});

	// $('.nextBtnTab1').attr("disabled", false);
	// disableToolTip();
	setTimeout(function() {
		$("#loaderWrap").hide();
	}, 2000);
}

// For product Registration tab4

function prdRegDetails(data) {

	const jsonData = JSON.parse(data);
	// alert(":::jsonData:::" + jsonData);

	var scedList = jsonData.fppRegJsonArray;

	if (scedList.length == 0) {
		$('.product-registration-wrapper').empty();
		console.log("NO DATA!")
		$('.product-registration-wrapper')
				.append(
						'<h2 style="text-align: center; color: red !important;">No Products have been selected for this tender!!!</h2>')
	} else {
		$('.product-registration-wrapper').empty();
		$('.product-registration-wrapper').append(
				'<h2>List of products per schedule</h2>');
	}

	$
			.each(
					scedList,
					function(key, value) {

						// clone schedule div and populate data
						var tenderItems = value.fppRegDetailsModel;
						var sechdProdList = $('.prodRegclone');

						var scheduleClone = sechdProdList.clone();

						if (!(jQuery.isEmptyObject(tenderItems))) {
							$
									.each(
											tenderItems,
											function(itemkey, itemValue) {

												// var tenderRefNo =
												// $("#tenderReferenceNumber").val(itemValue.tenderReferenceNumber);
												$(
														'.tender-submission-container .text-note .ref-num-note #tenderReferenceNumber')
														.text(
																itemValue.tenderReferenceNumber);

												var tendTrList = $('.prodRegTableclone');
												var tenderClone = tendTrList
														.clone();

												scheduleClone
														.find(
																'.accordion-header #schedNum')
														.text(
																value.scheduleNumber);

												tenderClone
														.find('#gdfGenCode')
														.val(
																itemValue.gdfGenericCode)
														.text(
																itemValue.gdfGenericCode);

												tenderClone
														.find(
																'#listOfCountries')
														.val(
																itemValue.listOfCountries)
														.text(
																itemValue.listOfCountries);
												tenderClone
														.find('#noOfCountries')
														.val(
																itemValue.noOfCountries)
														.text(
																itemValue.noOfCountries);
												tenderClone
														.find('#fppRegId')
														.val(itemValue.fppRegId)
														.text(
																itemValue.fppRegId);

												tenderClone
														.find('#fppRegStatus')
														.val(
																itemValue.fppRegStatus)
														.text(
																itemValue.fppRegStatus);
												/*
												 * tenderClone .find(
												 * '#fppRegAcceptedStatus')
												 * .val(
												 * itemValue.fppRegAcceptedStatus)
												 * .text(
												 * itemValue.fppRegAcceptedStatus);
												 */
												tenderClone
														.find(
																'#tenderReferenceNumber')
														.val(
																itemValue.tenderReferenceNumber)
														.text(
																itemValue.tenderReferenceNumber);

												tenderClone
														.find(
																'#gdfTenderItemMatRefID')
														.val(
																itemValue.gdfTenderItemMatRefID)
														.text(
																itemValue.gdfTenderItemMatRefID);
												tenderClone
														.find(
																'#tenderFPPRegRefNumber')
														.val(
																itemValue.tenderFPPRegRefNumber)
														.text(
																itemValue.tenderFPPRegRefNumber);

												scheduleClone.find(
														'.tbl_posts_body')
														.append(tenderClone);
												scheduleClone
														.find(
																'.tenderItemsData')
														.removeClass(
																'prodRegTableclone');

											});

							$('.product-registration-wrapper').append(
									scheduleClone);
							$('.product-registration-wrapper .list-product')
									.removeClass('prodRegclone');
							$(
									'.product-registration-wrapper .list-product .panel')
									.attr('style', 'display:none');

							$(
									'.product-registration-wrapper .list-product .accordion-header')
									.first().addClass('accordion-active');
							$(
									'.product-registration-wrapper .list-product .panel')
									.first().attr('style', 'display:block');

						}
					});

}

// For product Registration tab 4
function fetchPrdRegDetails(ajaxUrl) {
	var tenderRefNo = $("#tenderReferenceNumber").val();
	var url = ajaxUrl;
	$("#loaderWrap").show();
	var data = {
		tenderRefNo : tenderRefNo
	};
	// alert(data);
	jQuery.post(url, data, function(data) {
		prdRegDetails(data);
		enableTooltip();
		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 1500);
	});
}

/*
 * $(document).on('click', '#fppRegAcceptedStatus', function() { alert("In check
 * function"); if ($(this).is(':checked')) { $(this).attr('value', 'true'); }
 * else { $(this).attr('value', 'false'); }
 * 
 * });
 */

$(document).on('click', '#fppRegAcceptedStatus', function() {

	var currentRow = $(this).closest("tr");
	var fppRegStatus = currentRow.find("#fppRegStatus").val();
	// alert("fppRegStatus::::"+fppRegStatus);

	if ($(this).is(':checked')) {
		$(this).attr('value', 'true');
		if (fppRegStatus == "Approved") {
			// alert("This product is eligible!!!");
			$(this).prop('checked', true);
			$(this).attr('value', 'true');
		} else if (fppRegStatus == "Pending" || fppRegStatus == "Draft") {

			popUpOpen('saveTenderPopUp');

			$(this).prop('checked', false);
			$(this).attr('value', 'false');
		}
	} else {
		$(this).attr('value', 'false');
	}

});

// save product registration tab4 ajax call

function saveProductsRegistration(ajaxUrl) {

	$("#loaderWrap").show();

	var tenderRefNo = $("#tenderReferenceNumber").val();

	var schedularJson = [];
	$(".product-registration-wrapper .list-product")
			.each(
					function() {
						itemsArray = [];
						$(this)
								.find(
										".tenderRootDiv .tenderItemTable .tbl_posts_body tr")
								.each(
										function() {

											itemsArray
													.push({
														gdfGenericCode : $(this)
																.find(
																		"#gdfGenCode")
																.val(),
														listOfCountries : $(
																this)
																.find(
																		"#listOfCountries")
																.val(),
														fppRegStatus : $(this)
																.find(
																		"#fppRegStatus")
																.val(),
														fppRegId : $(this)
																.find(
																		"#fppRegId")
																.val(),
														tenderReferenceNumber : $(
																this)
																.find(
																		"#tenderReferenceNumber")
																.val(),
														fppRegAcceptedStatus : $(
																this)
																.find(
																		"#fppRegAcceptedStatus")
																.val(),
														tenderFPPRegRefNumber : $(
																this)
																.find(
																		"#tenderFPPRegRefNumber")
																.val(),
														gdfTenderItemMatRefID : $(
																this)
																.find(
																		"#gdfTenderItemMatRefID")
																.val(),
														tenderItemNumber : $(
																this).find(
																"#tendItem")
																.val(),
													// countryNames :
													// $(this).find("#countryNames").val(),
													})

										});

						schedularJson.push({
							schduleNumber : $(this).find("#schedNum").text(),
							tenderItems : itemsArray
						});

					});

	// alert(":::schedularJson:::" + schedularJson);
	var jsonInput = {
		tenderRefNo : tenderRefNo,
		selectedPrdRegArr : schedularJson
	};

	// alert(":::jsonInput:::" + jsonInput);
	var url = ajaxUrl;

	var data = {
		"requestData" : JSON.stringify(jsonInput)
	};

	jQuery.post(url, data, function(data) {

		var response = JSON.stringify(eval("(" + data + ")"));
		// alert(":::response:::" + response);
		var json = JSON.parse(response);
		// alert(":::json:::" + json);

		$('.adhocinfo').empty()
		$('.adhocinfo').append(html);

	});

	// $('.nextBtnTab1').attr("disabled", false);
	disableToolTip();
	setTimeout(function() {
		$("#loaderWrap").hide();
	}, 2000);
}

// edit product registration tab4 ajax call

function editProductsRegistration(ajaxUrl) {

	$("#loaderWrap").show();

	var tenderRefNo = $("#tenderReferenceNumber").val();

	var schedularJson = [];
	$(".product-registration-wrapper .list-product")
			.each(
					function() {
						itemsArray = [];
						$(this)
								.find(
										".tenderRootDiv .tenderItemTable .tbl_posts_body tr")
								.each(
										function() {

											itemsArray
													.push({
														gdfGenericCode : $(this)
																.find(
																		"#gdfGenCode")
																.val(),
														listOfCountries : $(
																this)
																.find(
																		"#listOfCountries")
																.val(),
														fppRegStatus : $(this)
																.find(
																		"#fppRegStatus")
																.val(),
														fppRegId : $(this)
																.find(
																		"#fppRegId")
																.val(),
														tenderReferenceNumber : $(
																this)
																.find(
																		"#tenderReferenceNumber")
																.val(),
														fppRegAcceptedStatus : $(
																this)
																.find(
																		"#fppRegAcceptedStatus")
																.val(),
														tenderFPPRegRefNumber : $(
																this)
																.find(
																		"#tenderFPPRegRefNumber")
																.val(),
														gdfTenderItemMatRefID : $(
																this)
																.find(
																		"#gdfTenderItemMatRefID")
																.val(),
														tenderItemNumber : $(
																this).find(
																"#tendItem")
																.val(),
													// countryNames :
													// $(this).find("#countryNames").val(),
													})

										});

						schedularJson.push({
							schduleNumber : $(this).find("#schedNum").text(),
							tenderItems : itemsArray
						});

					});

	// alert(":::schedularJson:::" + schedularJson);
	var jsonInput = {
		tenderRefNo : tenderRefNo,
		selectedPrdRegArr : schedularJson
	};

	// alert(":::jsonInput:::" + jsonInput);
	var url = ajaxUrl;

	var data = {
		"requestData" : JSON.stringify(jsonInput)
	};

	jQuery.post(url, data, function(data) {

		var response = JSON.stringify(eval("(" + data + ")"));
		// alert(":::response:::" + response);
		var json = JSON.parse(response);
		// alert(":::json:::" + json);

		$('.adhocinfo').empty()
		$('.adhocinfo').append(html);

	});

	// $('.nextBtnTab1').attr("disabled", false);
	// disableToolTip();
	setTimeout(function() {
		$("#loaderWrap").hide();
	}, 2000);
}

// For 2nd tab edit mode
function editProdSelection(data) {
	$("#fppSelTenderSub").next('.error').remove();

	const jsonData = JSON.parse(data);

	var submittedStatus = $("#tenderSubmissionStatus").val();
	// alert(":::submittedStatus:::"+submittedStatus);
	var tenderStatus = $("#tenderDetailsStatus").val();
	// alert(":::tenderStatus:::"+tenderStatus);

	var tenderRefNo = $("#tenderReferenceNumber").val();
	$(
			'.tender-submission-container .text-note .ref-num-note #tenderReferenceNumber')
			.text(tenderRefNo);

	var scedList = jsonData.schedFppMartJsonArray;

	if (scedList.length == 0) {
		$('.select-product-wrapper').empty();
		console.log("NO DATA!")
		$('.select-product-wrapper')
				.append(
						'<h2 style="text-align: center; color: red !important;">No Schedules are avilable for this tender!!!</h2>')
	} else {
		$('.select-product-wrapper').empty();
		$('.select-product-wrapper').append(
				'<h2>List of products per schedule</h2>');
	}

	$
			.each(
					scedList,
					function(key, value) {

						// clone schedule div and populate data
						var tenderItems = value.fppMartModelList;
						var sechdProdList = $('.prodclone');

						var scheduleClone = sechdProdList.clone();
						if (!(jQuery.isEmptyObject(tenderItems))) {

							$
									.each(
											tenderItems,
											function(itemkey, itemValue) {

												var tendTrList = $('.prodTableclone');
												var tenderClone = tendTrList
														.clone();

												scheduleClone
														.find(
																'.accordion-header #schedNum')
														.text(
																value.scheduleNumber);

												tenderClone
														.find('#tendItem')
														.val(
																itemValue.tenderItemNumber);
												tenderClone
														.find('#gdfGenCode')
														.text(
																itemValue.gdfGenericCode);
												tenderClone
												.find('#gdfGenCode').attr('href','/web/guest/fppinmarket/edit?fppMarketId='+itemValue.fppMarketId);

												tenderClone
														.find('#dosageForm')
														.val(
																itemValue.dosageForm);
												tenderClone
														.find(
																'#noOfUnitsForPrimPack')
														.val(
																itemValue.noOfPrimaryPackaging);
												tenderClone
														.find(
																'#noOfUnitsForSecPack')
														.val(
																itemValue.noOfSecondaryPackaging);
												tenderClone
														.find('#fppMarStauts')
														.val(
																itemValue.fppMartStatus);
												tenderClone
														.find(
																'#tenderFPPMatRefNumber')
														.val(
																itemValue.tenderFPPMatRefNumber);
												tenderClone
														.find('#fppMarketId')
														.val(
																itemValue.fppMarketId);
												
												tenderClone
														.find(
																'#tenderReferenceNumber')
														.val(
																itemValue.tenderReferenceNumber);

												if (itemValue.fppSelTenderSub == true
														&& itemValue.fppMartStatus == "Approved") {
													// $("#fppSelTenderSub").next('.error').remove();
													// alert("fppSelTenderSub111"
													// +
													// itemValue.fppSelTenderSub);
													tenderClone
															.find(
																	'#fppSelTenderSub')
															.val(
																	itemValue.fppSelTenderSub)
															.prop("checked",
																	true);

												} else {
													// alert("fppSelTenderSub222"
													// +
													// itemValue.fppSelTenderSub);
													tenderClone
															.find(
																	'#fppSelTenderSub')
															.val(
																	itemValue.fppSelTenderSub)
															.prop("checked",
																	false);
													/*
													 * $('#fppSelTenderSub').prop('value',
													 * 'false');
													 * $("#fppSelTenderSub").after("<div
													 * class='error'
													 * style='color:red;'>This
													 * GDF Approval status has
													 * changed!!!</div>");
													 */

												}

												if (submittedStatus == 'Submitted'
														|| tenderStatus == "Closed" || tenderStatus == 'Cancelled') {
													tenderClone
															.find(
																	'#fppSelTenderSub')
															.val(
																	itemValue.fppSelTenderSub)
															.prop("disabled",
																	true);
													$('.btn-save').prop(
															"disabled", true);
												} else {
													tenderClone
															.find(
																	'#fppSelTenderSub')
															.val(
																	itemValue.fppSelTenderSub)
															.prop("disabled",
																	false);
													$('.btn-save').prop(
															"disabled", false);
												}

												// scheduleClone.find('.tenderItemsData').val('').remove();
												scheduleClone.find(
														'.tbl_posts_body')
														.append(tenderClone);
												scheduleClone
														.find(
																'.tenderItemsData')
														.removeClass(
																'prodTableclone');

											});

							// For 2nd tab

							$('.select-product-wrapper').append(scheduleClone);
							$('.select-product-wrapper .list-product')
									.removeClass('prodclone');
							$('.select-product-wrapper .list-product .panel')
									.attr('style', 'display:none');

							$(
									'.select-product-wrapper .list-product .accordion-header')
									.first().addClass('accordion-active');
							$('.select-product-wrapper .list-product .panel')
									.first().attr('style', 'display:block');
						}
					});

}

// for 2nd tab edit Select FPP Market
function editSelectGdfTenders(ajaxUrl) {
	var tenderRefNo = $("#tenderReferenceNumber").val();

	var url = ajaxUrl;
	$("#loaderWrap").show();
	var data = {
		tenderRefNo : tenderRefNo
	};
	// alert(data);
	jQuery.post(url, data, function(data) {
		editProdSelection(data);
		// enableTooltip();
		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 1500);
	});
}

// For product Registration tab4

function editSelPrdRegDetails(data) {

	const jsonData = JSON.parse(data);
	// alert(":::jsonData:::" + jsonData);

	var submittedStatus = $("#tenderSubmissionStatus").val();
	// alert(":::submittedStatus:::"+submittedStatus);
	var tenderStatus = $("#tenderDetailsStatus").val();
	// alert(":::tenderStatus:::"+tenderStatus);
	$('#tenderSubmissionStatus').val(submittedStatus);
	$('#tenderDetailsStatus').val(tenderStatus);
	var scedList = jsonData.fppRegJsonArray;

	if (scedList.length == 0) {
		$('.product-registration-wrapper').empty();
		console.log("NO DATA!")
		$('.product-registration-wrapper')
				.append(
						'<h2 style="text-align: center; color: red !important;">No Schedules are avilable for this tender!!!</h2>')
	} else {
		$('.product-registration-wrapper').empty();
		$('.product-registration-wrapper').append(
				'<h2>List of products per schedule</h2>');
	}

	$
			.each(
					scedList,
					function(key, value) {

						// clone schedule div and populate data
						var tenderItems = value.fppRegDetailsModel;
						var sechdProdList = $('.prodRegclone');

						var scheduleClone = sechdProdList.clone();

						if (!(jQuery.isEmptyObject(tenderItems))) {
							$
									.each(
											tenderItems,
											function(itemkey, itemValue) {

												/*
												 * var tenderItemNumber
												 * =$("#tendItem").val(itemValue.tenderItemNumber);
												 * alert("::::tenderItemNumber::::"+tenderItemNumber);
												 */
												$(
														'.tender-submission-container .text-note .ref-num-note #tenderReferenceNumber')
														.text(
																itemValue.tenderReferenceNumber);

												var tendTrList = $('.prodRegTableclone');
												var tenderClone = tendTrList
														.clone();

												scheduleClone
														.find(
																'.accordion-header #schedNum')
														.text(
																value.scheduleNumber);

												tenderClone
														.find('#gdfGenCode')
														.val(
																itemValue.gdfGenericCode)
														.text(
																itemValue.gdfGenericCode);

												tenderClone
														.find(
																'#listOfCountries')
														.val(
																itemValue.listOfCountries)
														.text(
																itemValue.listOfCountries);
												tenderClone
														.find('#noOfCountries')
														.val(
																itemValue.noOfCountries)
														.text(
																itemValue.noOfCountries);
												tenderClone
														.find('#tendItem')
														.val(
																itemValue.tenderItemNumber)
														.text(
																itemValue.tenderItemNumber);

												tenderClone
														.find('#fppRegId')
														.val(itemValue.fppRegId)
														.text(
																itemValue.fppRegId);

												tenderClone
														.find('#fppRegStatus')
														.val(
																itemValue.fppRegStatus)
														.text(
																itemValue.fppRegStatus);

												tenderClone
														.find(
																'#tenderReferenceNumber')
														.val(
																itemValue.tenderReferenceNumber)
														.text(
																itemValue.tenderReferenceNumber);

												tenderClone
														.find(
																'#gdfTenderItemMatRefID')
														.val(
																itemValue.gdfTenderItemMatRefID)
														.text(
																itemValue.gdfTenderItemMatRefID);
												tenderClone
														.find(
																'#tenderFPPRegRefNumber')
														.val(
																itemValue.tenderFPPRegRefNumber)
														.text(
																itemValue.tenderFPPRegRefNumber);

												if (itemValue.fppRegAcceptedStatus == true
														&& itemValue.fppRegStatus == "Approved") {

													tenderClone
															.find(
																	'#fppRegAcceptedStatus')
															.val(
																	itemValue.fppRegAcceptedStatus)
															.prop("checked",
																	true);

												} else {

													tenderClone
															.find(
																	'#fppRegAcceptedStatus')
															.val(
																	itemValue.fppRegAcceptedStatus)
															.prop("checked",
																	false);

												}

												if (submittedStatus == 'Submitted'
														|| tenderStatus == 'Closed' || tenderStatus == 'Cancelled') {
													tenderClone
															.find(
																	'#fppRegAcceptedStatus')
															.val(
																	itemValue.fppRegAcceptedStatus)
															.prop("disabled",
																	true);
													$('.btn-save').prop(
															"disabled", true);
												} else {
													tenderClone
															.find(
																	'#fppRegAcceptedStatus')
															.val(
																	itemValue.fppRegAcceptedStatus)
															.prop("disabled",
																	false);
													$('.btn-save').prop(
															"disabled", false);
												}

												scheduleClone.find(
														'.tbl_posts_body')
														.append(tenderClone);
												scheduleClone
														.find(
																'.tenderItemsData')
														.removeClass(
																'prodRegTableclone');

											});

							$('.product-registration-wrapper').append(
									scheduleClone);
							$('.product-registration-wrapper .list-product')
									.removeClass('prodRegclone');
							$(
									'.product-registration-wrapper .list-product .panel')
									.attr('style', 'display:none');

							$(
									'.product-registration-wrapper .list-product .accordion-header')
									.first().addClass('accordion-active');
							$(
									'.product-registration-wrapper .list-product .panel')
									.first().attr('style', 'display:block');

						}
					});

}

// For edit product Registration tab 4
function editPrdRegDetails(ajaxUrl) {
	var tenderRefNo = $("#tenderReferenceNumber").val();
	var url = ajaxUrl;
	$("#loaderWrap").show();
	var data = {
		tenderRefNo : tenderRefNo
	};
	// alert(data);
	jQuery.post(url, data, function(data) {
		editSelPrdRegDetails(data);
		// enableTooltip();
		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 1500);
	});
}

function regCerificate(url, namespace, fileDeleteUrl) {
	if (!$('#regCerti').val() == "") {
		$('.submissionProofFile').hide();
		$("#loaderWrap").show();
		var allowFileToUpload = true;
		var oMyForm = new FormData();

		var filedata = document.getElementsByName(namespace + "regCerti");

		var len = filedata.length, regCerti;

		console.log("length:" + len)
		for (var i = 0; i < len; i++) {
			regCerti = filedata[i].files[0];
			console.log("regCerti: " + len + " " + regCerti);
			oMyForm.append("regCerti", regCerti);
		}

		oMyForm.append("tenderReferenceNumber", document
				.getElementById("tenderReferenceNumber").value);
		// oMyForm.append("gdfGenericCode",
		// document.getElementById("gdfGenericCode").value);

		$.ajax({
			url : url,
			data : oMyForm,
			type : "POST",
			enctype : 'multipart/form-data',
			async : false,
			processData : false,
			contentType : false,
			success : function(data) {
				var response = JSON.stringify(eval("(" + data + ")"));
				console.log("response :" + response);
				var json = JSON.parse(response);
				console.log("response:" + response);
				$('#certiReg').html("");
				$("#regCount").val('true');

				var url = json.fileUrl.split(",");
				var urlSize = url.length;
				url.forEach(function(url) {
					var name = url.split("/");
					if (url.length > 0) {
						var tableRow = "<li><a target=\"_blank\" href=\"" + url
								+ "\">" + name[name.length - 1] + "</a>";
						/*
						 * if(urlSize>1){ tableRow=tableRow+"<button
						 * class=\"btn fa fa-remove\" type=\"button\"
						 * onclick=\"deleteUploadedFile('"+fileDeleteUrl+"','"+name[name.length-1]+"','"+url+"','"+fileDeleteUrl+"')\"></button>" ; }
						 */
						tableRow = tableRow + "</li>";
					}

					$('#certiReg').append(tableRow);
					$('.multifile_container').find("p").remove();
				});
				$("#tenderReferenceNumber").val(json.tenderReferenceNumber);

			},
			error : function(result) {
				console.log("error in ajax method");
			}

		});
		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 1000);
		return allowFileToUpload;
	}
}

function downloadCountryProdRegFile(ajaxUrl) {
	var tenderRefNo = $("#tenderReferenceNumber").val();
	// alert("::in downloadCountryProdRegFile function::"+tenderRefNo);
	$("#loaderWrap").show();
	var url = ajaxUrl;
	var data = {
		tenderRefNo : tenderRefNo
	};
	jQuery.post(url, data, function(data) {
		var response = JSON.stringify(eval("(" + data + ")"));
		var json = JSON.parse(response);
		var fileName = json.fileName;
		startDownload(fileName);

		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 2000);
	});
}

function downloadTechBidsFile(ajaxUrl) {
	var tenderRefNo = $("#tenderReferenceNumber").val();
	// alert("::in downloadTechBidsFile function::"+tenderRefNo);
	$("#loaderWrap").show();
	var url = ajaxUrl;
	var data = {
		tenderRefNo : tenderRefNo
	};
	jQuery.post(url, data, function(data) {
		var response = JSON.stringify(eval("(" + data + ")"));
		var json = JSON.parse(response);
		var fileName = json.fileName;
		// alert(fileName);
		// $("#donwloadFile_"+fppId).attr("href", fileName);
		// $("#donwloadFile_"+fppId).attr("target", "_blank");
		startDownload(fileName);

		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 2000);
	});
}

function startDownload(url) {
	var url = url;
	window.open(url, 'Download');
}

$(document).on('click', '#iAgree', function() {

	if ($(this).is(':checked')) {
		$(this).attr('value', 'true');

	} else {
		$(this).attr('value', 'false');
	}

	if ($('#iAgree').val() == 'true') {
		// alert("In check if function");
		$('#tenderReferenceNumber').attr('required', true);
		$('#supplierName').attr('required', true);
		$('#authRepresenName').attr('required', true);
		$('#supplierTitle').attr('required', true);
		$('#emailAddr').attr('required', true);
		$('#telephone').attr('required', true);
		$('#regCerti').attr('required', false);

		$('.submitbuttton').removeAttr('disabled', false);
		// $('#cancelbtn').removeAttr('disabled', false);
	} else {
		// alert("In check if else function");
		$('.submitbuttton').attr('disabled', true);
		// $('#cancelbtn').attr('disabled', true);
	}
});

function saveTenderSubDetails(ajaxUrl) {

	$("#loaderWrap").show();

	var tenderRefNo = $("#tenderReferenceNumber").val();
	var supplierName = $("#supplierName").val();
	var respresentName = $("#authRepresenName").val();
	var supplierTitle = $("#supplierTitle").val();
	var emailAddr = $("#emailAddr").val();
	var telephone = $("#telephone").val();

	var jsonInput = {
		tenderRefNo : tenderRefNo,
		supplierName : supplierName,
		respresentName : respresentName,
		supplierTitle : supplierTitle,
		emailAddr : emailAddr,
		telephone : telephone
	};

	var url = ajaxUrl;

	var data = {
		"requestData" : JSON.stringify(jsonInput)
	};

	// alert(":::saveTenderSubDetails:::" + JSON.stringify(jsonInput));
	jQuery.post(url, data, function(data) {

		var response = JSON.stringify(eval("(" + data + ")"));
		// alert(":::response:::" + response);
		var json = JSON.parse(response);
		// alert(":::json:::" + json);

		$('.adhocinfo').empty()
		$('.adhocinfo').append(html);

	});
	$('.cancelMsg').empty();
	$('.successMsg').attr('style', 'display:block');

	setTimeout(function() {
		$("#loaderWrap").hide();
	}, 2000);
}

function submitTenderSubDetails(ajaxUrl) {

	$("#loaderWrap").show();

	var tenderRefNo = $("#tenderReferenceNumber").val();
	var supplierName = $("#supplierName").val();
	var respresentName = $("#authRepresenName").val();
	var supplierTitle = $("#supplierTitle").val();
	var emailAddr = $("#emailAddr").val();
	var telephone = $("#telephone").val();

	var jsonInput = {
		tenderRefNo : tenderRefNo,
		supplierName : supplierName,
		respresentName : respresentName,
		supplierTitle : supplierTitle,
		emailAddr : emailAddr,
		telephone : telephone
	};

	var url = ajaxUrl;

	var data = {
		"requestData" : JSON.stringify(jsonInput)
	};

	// alert(":::saveTenderSubDetails:::" + JSON.stringify(jsonInput));
	jQuery.post(url, data, function(data) {

		var response = JSON.stringify(eval("(" + data + ")"));
		// alert(":::response:::" + response);
		var json = JSON.parse(response);
		// alert(":::json:::" + json);

		$('.adhocinfo').empty()
		$('.adhocinfo').append(html);

	});

	setTimeout(function() {
		$("#loaderWrap").hide();
	}, 2000);
}

function cancelTenderSubDetails(ajaxUrl) {
	$("#cancelbtn").next('.error').remove();

	var dateEntered = $("#deadLineDate").val();
	var date = dateEntered.substring(0, 2);
	var month = dateEntered.substring(3, 5);
	var year = dateEntered.substring(6, 10);

	var deadLineDate = new Date(year, month - 1, date);
	var currentDate = new Date();

	if (deadLineDate <= currentDate) {

		// alert("Date Entered is lesser than Current Date");
		$("#cancelbtn")
				.after(
						"<div class='error' style='color:red;'>This tender is not eligible to cancel its technical bids!!!</div>");
	} else {
		// alert("Date Entered is greater than Current Date ");
		$("#loaderWrap").show();
		var tenderRefNo = $("#tenderReferenceNumber").val();
		var supplierName = $("#supplierName").val();
		var respresentName = $("#authRepresenName").val();
		var supplierTitle = $("#supplierTitle").val();
		var emailAddr = $("#emailAddr").val();
		var telephone = $("#telephone").val();

		var jsonInput = {
			tenderRefNo : tenderRefNo,
			supplierName : supplierName,
			respresentName : respresentName,
			supplierTitle : supplierTitle,
			emailAddr : emailAddr,
			telephone : telephone
		};

		var url = ajaxUrl;

		var data = {
			"requestData" : JSON.stringify(jsonInput)
		};

		// alert(":::saveTenderSubDetails:::" + JSON.stringify(jsonInput));
		jQuery.post(url, data, function(data) {

			var response = JSON.stringify(eval("(" + data + ")"));
			// alert(":::response:::" + response);
			var json = JSON.parse(response);
			// alert(":::json:::" + json);

			$('.adhocinfo').empty()
			$('.adhocinfo').append(html);

		});
		$('.successMsg').empty();
		$('.cancelMsg').attr('style', 'display:block');

		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 2000);
	}
}

function tenderNextTab(data) {

	var jsonData = JSON.parse(data);

	var submittedStatus = $("#tenderSubmissionStatus").val();
	// alert(":::submittedStatus:::"+submittedStatus);
	var tenderStatus = $("#tenderDetailsStatus").val();
	// alert(":::tenderStatus:::"+tenderStatus);

	$('.tender-detail-form #supplierName').val(jsonData.supplierName);
	$('.tender-detail-form #authRepresenName').val(jsonData.nameOfAuthRepr);
	$('.tender-detail-form #supplierTitle').val(jsonData.supplierTitle);
	$('.tender-detail-form #emailAddr').val(jsonData.supplierEmailAddress);
	$('.tender-detail-form #telephone').val(jsonData.supplierTelephoneNumber);
	$('#deadLineDate').val(jsonData.deadLineDateForTechBids);

	if (submittedStatus == 'Submitted') {
		$('#authRepresenName').prop("disabled", true);
		$('#supplierTitle').prop("disabled", true);
		$('#emailAddr').prop("disabled", true);
		$('#telephone').prop("disabled", true);
		$('#linkPrimary').prop("disabled", true);
		$('#regCerti').prop("disabled", true);
		$('#regCertiFile').prop("disabled", true);
		$('#iAgree').prop("disabled", true);
		$('.submitbuttton').prop("disabled", true);
		$('#cancelbtn').prop("disabled", true);
		$('.btn-save').prop("disabled", true);

	}/*
		 * else { $('#authRepresenName').prop("disabled", false);
		 * $('#supplierTitle').prop("disabled", false);
		 * $('#emailAddr').prop("disabled", false);
		 * $('#telephone').prop("disabled", false);
		 * $('#linkPrimary').prop("disabled", false);
		 * $('#regCerti').prop("disabled", false);
		 * $('#regCertiFile').prop("disabled", false);
		 * $('#iAgree').prop("disabled", false);
		 * $('.submitbuttton').prop("disabled", false);
		 * $('#cancelbtn').prop("disabled", false);
		 * $('.btn-save').prop("disabled", false); }
		 */

	if (tenderStatus == 'Cancelled' || tenderStatus == 'Closed') {
		/*
		 * $('#regCerti').prop("disabled", true);
		 * $('#regCertiFile').prop("disabled", true);
		 * $('#cancelbtn').prop("disabled", true);
		 * $('.btn-save').prop("disabled", true);
		 */
		$('.submitbuttton').prop("disabled", true);
		$('#iAgree').prop("disabled", true);

		$('#authRepresenName').prop("disabled", true);
		$('#supplierTitle').prop("disabled", true);
		$('#emailAddr').prop("disabled", true);
		$('#telephone').prop("disabled", true);
		$('#linkPrimary').prop("disabled", true);
		$('#regCerti').prop("disabled", true);
		$('#regCertiFile').prop("disabled", true);
		$('#cancelbtn').prop("disabled", true);
		$('.btn-save').prop("disabled", true);
	}/*
		 * else { $('#regCerti').prop("disabled", false);
		 * $('#regCertiFile').prop("disabled", false);
		 * $('#cancelbtn').prop("disabled", false);
		 * $('.btn-save').prop("disabled", false); $('#iAgree').prop("disabled",
		 * false); $('.submitbuttton').prop("disabled", false);
		 * 
		 * $('#authRepresenName').prop("disabled", false);
		 * $('#supplierTitle').prop("disabled", false);
		 * $('#emailAddr').prop("disabled", false);
		 * $('#telephone').prop("disabled", false);
		 * $('#linkPrimary').prop("disabled", false);
		 * $('#regCerti').prop("disabled", false);
		 * $('#regCertiFile').prop("disabled", false);
		 * $('#cancelbtn').prop("disabled", false);
		 * $('.btn-save').prop("disabled", false);
		 *  }
		 */
}

// For edit product Registration tab 4
function tenderSubNextDetails(ajaxUrl) {
	var tenderRefNo = $("#tenderReferenceNumber").val();
	var url = ajaxUrl;
	$("#loaderWrap").show();
	var data = {
		tenderRefNo : tenderRefNo
	};
	// alert(data);
	jQuery.post(url, data, function(data) {
		tenderNextTab(data);
		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 1500);
	});
}

$(document).on('click', '#saveTenderSub', function() {
	// alert("In submit button function");
	var supplierName = $("#supplierName").val();

	var tenderReferenceNumber = $("#tenderReferenceNumber").val();

	$(".tenderRefNumber").val(tenderReferenceNumber);
	$(".nameOfSupplier").val(supplierName);

	// alert("tenderReferenceNumber::"+$(".tenderRefNumber").val(tenderReferenceNumber)+"supplierName::"+$(".nameOfSupplier").val(supplierName));
});

/*
 * $(document).on('change', '#regCerti', function() {
 * $("#regCerti").next('.error').remove(); var fileExtension = ['jpeg', 'jpg',
 * 'pdf','xls', 'xlsx', 'doc', 'txt', 'ppt', 'png']; if
 * ($.inArray($(this).val().split('.').pop().toLowerCase(), fileExtension) ==
 * -1) { // alert("Only '.jpeg','.jpg','.pdf','.xls', '.xlsx', '.doc', '.txt',
 * '.ppt', '.png' formats are allowed."); $("#regCerti").after("<div
 * class='error' style='color:red;'>Please upload file with valid extensions
 * only</div>"); return false; } });
 */

$(document)
		.on(
				'change',
				'#regCerti',
				function() {
					$("#regCerti").next('.error').remove();

					var fileExtension = [ 'jpeg', 'jpg', 'pdf', 'xls', 'xlsx',
							'doc', 'txt', 'ppt', 'png' ];
					if ($.inArray($(this).val().split('.').pop().toLowerCase(),
							fileExtension) == -1) {
						// alert("Only '.jpeg','.jpg','.pdf','.xls', '.xlsx',
						// '.doc', '.txt', '.ppt', '.png' formats are
						// allowed.");
						$("#regCerti")
								.after(
										"<div class='error' style='color:red;'>Please upload file with valid extensions only</div>");
						$("#nameChoosen").val("");
						$('.multifile_container').text('');
						/*
						 * $('.multifile_remove_input').text('');
						 * $('span.filename').text('');
						 */
						return false;
					}
				});

$(document)
		.on(
				'click',
				'#submitbtn',
				function() {
					$("#emailAddr").next('.error').remove();

					var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
					var hasError = false;
					var emailaddressVal = $("#emailAddr").val();

					if ($("#emailAddr").val() == "") {
						// alert("In Email Address if ");
						$("#emailAddr")
								.after(
										"<div class='error' style='color:red;'>Please enter email addrress</div>");
						hasError = false;
					} else if (!emailReg.test(emailaddressVal)) {
						// alert("In Email Address else");
						$("#emailAddr")
								.after(
										'<span class="error" style="color:red;">Enter a valid email address.</span>');
						hasError = true;

					}
					if (hasError == true) {
						return false;
					}

				});

function validateForm(url) {

	$('#regCerti').attr('required', false);
	$("#submitbtn").next('.error').remove();

	/*
	 * var supplierName = $("#supplierName").val(); var authRepresenName =
	 * $("#authRepresenName").val(); var supplierTitle =
	 * $("#supplierTitle").val(); var emailAddr = $("#emailAddr").val(); var
	 * telephone = $("#telephone").val(); var tenderReferenceNumber =
	 * $("#tenderReferenceNumber").val(); var regCerti = $("#regCerti
	 * .multifile_container .filename").val();
	 * 
	 * 
	 */

	var dateEntered = $("#deadLineDate").val();
	var date = dateEntered.substring(0, 2);
	var month = dateEntered.substring(3, 5);
	var year = dateEntered.substring(6, 10);

	var deadLineDate = new Date(year, month - 1, date);
	var currentDate = new Date();

	$("#supplierName").next('.error').remove();
	$("#authRepresenName").next('.error').remove();
	$("#supplierTitle").next('.error').remove();
	$("#emailAddr").next('.error').remove();
	$("#telephone").next('.error').remove();
	$("#regCerti").next('.error').remove();

	if ($("#authRepresenName").val() == "" || $("#supplierTitle").val() == ""
			|| $("#emailAddr").val() == "" || $("#telephone").val() == ""
			|| $("#regCerti").val() == "") {
		if ($("#authRepresenName").val() == "") {
			$("#authRepresenName")
					.after(
							"<div class='error' style='color:red;'>Please enter name of authorized representative</div>");
		}
		if ($("#supplierTitle").val() == "") {
			$("#supplierTitle")
					.after(
							"<div class='error' style='color:red;'>Please enter supplier title</div>");
		}

		if ($("#telephone").val() == "") {
			$("#telephone")
					.after(
							"<div class='error' style='color:red;'>Please enter telephone number</div>");
		}
		if ($("#regCerti").val() == "" || $("#nameChoosen").val() == "") {
			$("#regCerti")
					.after(
							"<div class='error' style='color:red;'>Please upload file</div>");
		}

	} else if (deadLineDate <= currentDate) {

		// alert("Date Entered is lesser than Current Date");
		popUpOpen('deadLineDateTenderSubmitPopUp');
	} else {
		popUpOpen('saveTenderPopUp');

	}
}

function deadLineDate(data) {
	var jsonData = JSON.parse(data);
	$('#deadLineDate').val(jsonData.deadLineDateForTechBids);
}

function fetchDeadLineDateDetails(ajaxUrl) {
	var tenderRefNo = $("#tenderReferenceNumber").val();

	var url = ajaxUrl;
	$("#loaderWrap").show();
	var data = {
		tenderRefNo : tenderRefNo,
	};
	// alert(data);
	jQuery.post(url, data, function(data) {
		deadLineDate(data);
		setTimeout(function() {
			$("#loaderWrap").hide();
		}, 1500);
	});
}
