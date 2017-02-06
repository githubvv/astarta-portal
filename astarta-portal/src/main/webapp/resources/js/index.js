/*import * as tmpl from 'templates'*/

/*var paySlipYear = new Date().getFullYear();

 var homePage = {
 "navProducer": ["Фінансова звітність","Відомість нарахування заробітної плати"],
 "navigation": []
 }*/

/*var report = `<div class="col-lg-12"><b>Розрахунковий лист ${paySlipReport.jsonObj["period"]}</b></div>
 <div class="table-responsive">${paySlipReport.html}</div>`;*/

var months = [{id: '01', text: 'Січень'}, {id: '02', text: 'Лютий'}, {id: '03', text: 'Березень'}, {
    id: '04',
    text: 'Квітень'
}, {id: '05', text: 'Травень'}, {id: '06', text: 'Червень'}, {id: '07', text: 'Липень'}, {
    id: '08',
    text: 'Серпень'
}, {id: '09', text: 'Вересень'}, {id: '10', text: 'Жовтень'}, {id: '11', text: 'Листопад'}, {
    id: '12',
    text: 'Грудень'
}];
var companies = [{id: '19371986', text: 'АСТАРТА-КИЇВ ТОВ'}, {id: '03770394', text: 'ДОВЖЕНКА ТОВ АФ'}, {
    id: '30547403',
    text: 'ГЛОБИНСЬКИЙ ПЕРЕРОБНИЙ ЗАВОД ТОВ'
}];

function loadSelect2El() {
    $('#sel-payslip-cal').select2({
        placeholder: "Місяць",
        allowClear: true
    });
    $('#sel-payslip-comp').select2({
        placeholder: "Організація",
        allowClear: true
    });
}

class ResourcePanel {
    constructor() {
        this.resPanelHTMLMap = resPanelHTMLMap;
    }

    openResPanel(panelName) {
    	if(panelName!==undefined)
    		$("#portalWorkspace").css({'height': '550px'}).html(this.resPanelHTMLMap[panelName]);

    }
}

class ReportPanel {
    constructor() {
        this.reportPanelHTMLMap = reportPanelHTMLMap;
    }

    openReportPanel(panelName) {
        let _reportPanelCtx = this;
        $("#portalWorkspace").css({'height': '550px'}).html(this.reportPanelHTMLMap[panelName]);
        $("#sel-payslip-cal").select2({
            allowClear: true,
            data: months,
            formatSelection: function (item) {
                return item.name
            },
            formatResult: function (item) {
                return item.name
            }
        }).val('');
        $("#sel-payslip-comp").select2({
            allowClear: true,
            data: companies,
            formatSelection: function (item) {
                return item.name
            },
            formatResult: function (item) {
                return item.name
            }
        }).val('');

        $("#yearVal-prev").on("click", function () {
            yearVal--;
            $("#yearVal-text").html(yearVal);
        });
        $("#yearVal-next").on("click", function () {
            let maxYear = new Date().getFullYear();
            if (yearVal + 1 > maxYear)
                return false;
            $("#yearVal-text").html(++yearVal);
        });
        $("#showPaySlipBtn").on("click", function () {
            _reportPanelCtx.showPaySlipRep();
        });
        loadSelect2El();
    }

    showPaySlipRep() {
        let month = $("#sel-payslip-cal").val();
        let edrpou = $("#sel-payslip-comp").val();
        getPaySlip(month, edrpou);
        /* $("#portalWorkspace").css({ 'height' : ''});*/
    }

    getYearVal() {
        return this.yearVal;
    }
}

class AuthController {
    constructor() {
    	this._authDetails = undefined;
    }

    get authDetails() {
        return this._authDetails;
    }

    set authDetails(value) {
        this._authDetails = value;
    }
}

/*function showPaySlipPanel(name) {
 switch (name) {
 case 'financy': {
 /!* PANEL-ACTIONS*!/
 /!* $("#category-blink").html("");*!/

 /!*PANEL-WORKSPACE*!/
 $("#workspace").html(category_tmpl["financy"]);
 /!*$("#ws-caption").html("Робочий стіл ");*!/

 /!*MAKE NAVIGATION*!/
 /!*
 makeNavString("Фінансова звітність");
 *!/

 break;
 }
 case undefined: {
 break;
 }
 default: {
 break;
 }
 }
 };*/

/*function prepareActPanelForPaySlip() {
 $("#act-caption").html("Панель дій ");
 $("#category-blink").html("Виберіть місяць");
 $("#tools").html(`
 <ul class="list-group">
 <li class="list-group-item payslip-mounth-list">
 <button id="paySlipYear-prev" type="button" class="btn-link"><i class="fa fa-chevron-left" aria-hidden="true"></i></button>
 <span id="paySlipYear-text">${paySlipYear}</span>
 <button id="paySlipYear-next" type="button" class="btn-link"><i class="fa fa-chevron-right" aria-hidden="true"></i></span></button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('01')">Січень</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('02')">Лютий</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('03')">Березень</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('04')">Квітень</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('05')">Травень</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('06')">Червень</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('07')">Липень</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('08')">Серпень</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('09')">Вересень</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('10')">Жовтень</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('11')">Листопад</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <button type="button" class="btn-link" onclick="getPaySlip('12')">Грудень</button>
 </li>
 <li class="list-group-item payslip-mounth-list">
 <input id="org" name="org" type="text"/>
 </li>
 </ul>`);

 $("#paySlipYear-prev").on("click", function () {
 paySlipYear--;
 $("#paySlipYear-text").html(paySlipYear);
 });

 $("#paySlipYear-next").on("click", function () {
 let maxYear = new Date().getFullYear();
 if(paySlipYear+1>maxYear)
 return false;
 $("#paySlipYear-text").html(++paySlipYear);
 });
 $("#panel-workspace").html(category_tmpl["financy"]);

 makeNavString("Відомість нарахування заробітної плати");
 }

 function makeNavString(name) {
 let index=0;
 let str="";
 let navList = homePage["navigation"];
 let navListSize = navList.length;

 if(name==""){
 $("#navigation-text").html("");
 homePage["navigation"] = [];
 return;
 }

 if(homePage["navProducer"].indexOf(name)==-1){
 let lastItem = homePage["navigation"][navListSize-1];
 if(homePage["navProducer"].indexOf(lastItem)!=-1)
 navList.push(name);
 else
 navList[navListSize-1] = name;
 }
 else{
 if ((index = navList.indexOf(name)) != -1) {
 navList = navList.slice(0,index+1);
 }
 else {
 navList.push(name);
 }
 ;

 }
 for(let i=0;i<navList.length;i++){
 if (i!=0)
 str +=" <i class='fa fa-long-arrow-right' aria-hidden='true'></i> ";
 str += homePage["navigation"][i];
 }

 homePage["navigation"] = navList;

 $("#navigation-text").html(str);
 }

 function goToCategoryPanel() {
 /!*PANEL-ACTIONS*!/
 $("#act-caption").html("Інформаційна панель ");
 $("#category-blink").html(`<span>Виберіть категорію...</span>`);
 $("#tools").html("");
 /!*PANEL-WORKSPACE*!/
 $("#ws-caption").html("Панель категорій ");
 $("#panel-workspace").html(category_tmpl["home"]);

 /!*MAKE NAVIGATION*!/
 /!*  makeNavString("");*!/
 }*/

function checkAuthentication(){
	 $.getJSON("/astarta-portal/org-structure/users/current-user/check-authentication", function(data, status){
		if(status!=="success")
			console.error("Server error getting user details!");
		if ($.isEmptyObject(data)) 
			authController.authDetails = undefined;
		else
			authController.authDetails = data;
		hanlePage();
	});
}

function hanlePage() {
    let $authText = $("#authText");
    let $loginLink = $("#loginLink");
    $loginLink.attr("data-toggle", "dropdown");
    $loginLink.text("Login");
    
    if (authController.authDetails === undefined) {
        $authText.text("Ви не аутентифіковані");
    }
    else {
        if (authController.authDetails["status"] == "success") {
            $loginLink.removeAttr("data-toggle");
            $loginLink.text("Logout");
            let userDetails = JSON.parse(authController.authDetails.userdetails);
            $authText.text(userDetails.lastName + " " + userDetails.firstName);
        }
        else {
            $authText.text("Невірно введені дані");
        }
    }
}

function changeLanguage(lang) {
    $.getJSON("/astarta-portal/locale?lang=" + lang, function (localeMapJSON) {
//		/* let localeMap = JSON.s(localeMapJSON);*/
        console.log(localeMapJSON);
    });
}

function userLogout(){
	let xsrfVal = $.cookie("XSRF-TOKEN");
	$.ajax({
		type:'POST',
		url: "/astarta-portal/logout",
		data: "_csrf="+xsrfVal	
	})
	.done(function(){
		fillCsrfHiddenField();
		authController.authDetails = undefined;
		hanlePage();
	})
	.fail(function(){
		 console.error('Error logout! ' + ' Status: ' +  error.status + '. Status text: ' + error.statusText);
	})
}


function fillElementEventListeners(){
	$(document).ajaxSend(function(elm, xhr, s){
	    if (s.type == "POST") {
	        xhr.setRequestHeader("X-XSRF-TOKEN", $("meta[name='_csrf']").attr("content"));
	    }
	});
	
	$("#loginLink").on("click",function(){
		var attr = $(this).attr("data-toggle");
		if (typeof attr === typeof undefined || attr === false) {
			userLogout();
		}
	});
	
	$("#loginBtn").on("click",function(e){
		let loginFormData = $("#loginForm").serialize();
		$("#loginContainer").removeClass("open");
		$.ajax({
		    type: 'POST',
		    url: '/astarta-portal/appLogin',
		    data: loginFormData
 		})
		.done(function(authResp) {
			if (authResp !== undefined) {
				fillCsrfHiddenField();
				authController.authDetails = authResp;
				hanlePage();
	        }
		})
		.fail(function(error) {
		    console.error('Error authentication! ' + ' Status: ' +  error.status + '. Status text: ' + error.statusText);
		}).always(function(){
			$("input[name='app_username']").val("");
			$("input[name='app_password']").val("");
		});
	});
	
}

var authController = new AuthController();
var resourcePanel = new ResourcePanel();
var reportPanel = new ReportPanel();

$(document).ready(function () {
	fillCsrfHiddenField();
    $("#portalHeader").html(portalHeader);
    $("#portalWorkspace").html(portalWorkspace);
    $("#portalFooter").html(portalFooter);
    checkAuthentication();
    fillElementEventListeners();
});
