var paySlipReport = {
    html:'',
    jsonObj: {},
    accruals:null,
    witheld:null,
    incomeInKind:null,
    paid:null,
    thead  : function(){
        return `<thead>
    <tr>
    <td colspan="7"><label>Організація:</label><span>${this.jsonObj["company"]}</span></td>
<td colspan="3"></td>
    </tr>
    <tr>
    <td colspan="7" rowspan="2"><span><b>${this.jsonObj["employee"]}</b></span></td>
<td colspan="3"><span>${this.jsonObj["department"]}</span></td>
</tr>
<tr>
<td colspan="3"><span>${this.jsonObj["position"]}</span></td>
    </tr>
    <tr>
    <td colspan="7"><label>Табельний номер:</label><span>${this.jsonObj["tabel"]}</span></td>
<td colspan="3" rowspan="2"></td>
    </tr>
    <tr>
    <td colspan="7"><label>Код за ДРФО:</label><span>${this.jsonObj["INN"]}</span></td>
</tr>
<tr>
<td colspan="12" class="empty-row"></td>
    </tr>
    <tr style="background-color: #ddfbdd;">
    <td rowspan="2" class="col-25">Вид</td>
    <td rowspan="2" class="col-10">Період</td>
    <td colspan="2" class="col-10">Відпрацьовано</td>
    <td colspan="2" class="col-10">Оплачено</td>
    <td rowspan="2" class="col-10">Сума</td>
    <td rowspan="2" class="col-15">Вид</td>
    <td rowspan="2" class="col-10">Період</td>
    <td rowspan="2" class="col-10">Сума</td>
    </tr>
    <tr style="background-color: #ddfbdd;">
    <td class="col-5">Дні</td>
    <td class="col-5">Години</td>
    <td class="col-5">Дні</td>
    <td class="col-5">Години</td>
    </tr>
    </thead>`},
    tfoot: function(){ return `   <tfoot class="total-color">
                <td colspan="6">Борг за підприємством на початок місяця</td>
                <td  class="numerical"><span>${this.jsonObj["debtAtStart"]}</span></td>
                <td colspan="2">Борг за підприємством на кінець місяця</td>
                <td class="numerical"><span>${this.jsonObj["debtAtEnd"]}</span></td>
                </tfoot>`},

    sec_1_2_head: function(){return ` <tr>
                    <td colspan="7"><b>1.Нараховано</b></td>
                    <td colspan="3"><b>2. Утримано</b></td>
                </tr>`},
    sec_1_2_footer: function(){return `<tr class="total">
                    <td colspan="2" class="col-25"><span>${this.jsonObj.accruals.total["title"]}</span></td>
                    <td class="col-5 total-color numerical"><span>${this.jsonObj.accruals.total["daysWorked"]}</span></td>
                    <td class="col-5 total-color numerical"><span>${this.jsonObj.accruals.total["hoursWorked"]}</span></td>
                    <td class="col-5 total-color numerical"><span>${this.jsonObj.accruals.total["daysPaid"]}</span></td>
                    <td class="col-5 total-color numerical"><span>${this.jsonObj.accruals.total["hoursPaid"]}</span></td>
                    <td class="col-10 total-color numerical"><span>${this.jsonObj.accruals.total["summa"]}</span></td>
                    <td colspan="2" class="col-25"><span>${this.jsonObj.witheld.total["title"]}</span></td>
                    <td class="col-10 total-color numerical"><span>${this.jsonObj.witheld.total["summa"]}</span></td>
                </tr>`},

    sec_3_4_head: function(){return `<tr>
                    <td colspan="7"><b>3. Доходи в натуральній формі</b></td>
                    <td colspan="3"><b>4. Виплачено</b></td>
                </tr>`},
    sec_3_4_footer: function(){return ` <tr class="total">
                    <td colspan="6" class="col-25"><span>${this.jsonObj.incomeInKind.total["title"]}</span></td>
                    <td class="col-10 numerical"><span>${this.jsonObj.incomeInKind.total["summa"]}</span></td>
                    <td colspan="2" class="col-25">${this.jsonObj.paid.total["title"]}</td>
                    <td class="col-10 numerical"><span>${this.jsonObj.paid.total["summa"]}</span></td>
                </tr>`},

    prepareTables: function () {
        let maxIndx = Math.max(this.jsonObj.accruals.list.length, this.jsonObj.witheld.list.length);
        this.accruals = this.jsonObj.accruals.list;
        this.witheld = this.jsonObj.witheld.list;
        this.accruals.length = this.witheld.length = maxIndx;

        maxIndx = Math.max(this.jsonObj.incomeInKind.list.length, this.jsonObj.paid.list.length);
        this.incomeInKind = this.jsonObj.incomeInKind.list;
        this.paid = this.jsonObj.paid.list;
        this.incomeInKind.length = this.paid.length = maxIndx;
    },

    addRowTo_1_2_Sec: function () {
        let rows = '';
        for(let i=0;i<this.accruals.length; i++){
            let accrual = this.accruals[i];
            let witheld = this.witheld[i];
            rows = rows + `<tr class="item">
                    <td class="col-25"><span>${(accrual==undefined)?"":accrual["typeName"]}</span></td>
                    <td class="col-10"><span>${(accrual==undefined)?"":accrual["period"]}</span></td>
                    <td class="col-5 numerical"><span>${(accrual==undefined)?"":accrual["daysWorked"]}</span></td>
                    <td class="col-5 numerical"><span>${(accrual==undefined)?"":accrual["hoursWorked"]}</span></td>
                    <td class="col-5 numerical"><span>${(accrual==undefined)?"":accrual["daysPaid"]}</span></td>
                    <td class="col-5 numerical"><span>${(accrual==undefined)?"":accrual["hoursPaid"]}</span></td>
                    <td class="col-10 numerical"><span>${(accrual==undefined)?"":accrual["summa"]}</span></td>
                    <td class="col-15"><span>${(witheld==undefined)?"":witheld["typeName"]}</span></td>
                    <td class="col-10"><span>${(witheld==undefined)?"":witheld["period"]}</span></td>
                    <td class="col-10 numerical"><span>${(witheld==undefined)?"":witheld["summa"]}</span></td>
                </tr>`;
        }
        return rows;
    },

    addRowTo_3_4_Sec: function () {
        let rows= '';
        for(let i=0; i<this.incomeInKind.length;i++){
            let incomeInKind = this.incomeInKind[i];
            let paid = this.paid[i];
            rows = rows + ` <tr class="item">
                    <td class="col-25"><span>${(incomeInKind==undefined)?"":incomeInKind["typeName"]}</span></td>
                    <td class="col-10"><span>${(incomeInKind==undefined)?"":incomeInKind["period"]}</span></td>
                    <td class="col-5"><span></span></td>
                    <td class="col-5"><span></span></td>
                    <td class="col-5"><span></span></td>
                    <td class="col-5"><span></span></td>
                    <td class="col-10 numerical"><span>${(incomeInKind==undefined)?"":incomeInKind["summa"]}</span></td>
                    <td class="col-15"><span>${(paid==undefined)?"":paid["typeName"]}</span></td>
                    <td class="col-10"><span>${(paid==undefined)?"":paid["period"]}</span></td>
                    <td class="col-10 numerical"><span>${(paid==undefined)?"":paid["summa"]}</span></td>
                </tr>`;
        }
        return rows;
    },

    makeHTML: function () {
        this.prepareTables();
        this.html = '<div class="table-responsive">';
        this.html = this.html + `<span><b>Розрахунковий лист ${paySlipReport.jsonObj["period"]}</b></span>`;
        this.html = this.html +'<table class="table table-bordered payslip_table">' + this.thead() ;
        this.html = this.html +'<tbody>';
        this.html = this.html + this.sec_1_2_head();
        this.html = this.html + this.addRowTo_1_2_Sec();
        this.html = this.html + this.sec_1_2_footer();
        this.html = this.html + this.sec_3_4_head();
        this.html = this.html + this.addRowTo_3_4_Sec();
        this.html = this.html + this.sec_3_4_footer();
        this.html = this.html + this.tfoot();
        this.html = this.html + '</tbody>';
        this.html = this.html + '</table>';
        this.html = this.html + '</div>';
    }
}


/*функкия получения параметров УРЛ*/
/*
 function getUrlVars() {
 var vars = {};
 var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi, function(m,key,value) {
 vars[key] = value;
 });
 return vars;
 }
 */

function getPaySlip(month, edrpou){
    let period = yearVal+"-"+month+"-01";
    /*let orgVal = $("#org").val();*/
    
    $.ajax({
        url: "/astarta-portal/payslip/get?period="+period +"&edrpou=" + edrpou,
        type: "GET",
        success: function(data){ 
        	let resp = "";
            if(data.error!=undefined){
                resp = `<h3 class="h3-empty-data">Данні відсутні!</h3>`;
                $("#portalWorkspace").css({ 'height' : '550px'});
            }
            else{
            	paySlipReport.jsonObj = JSON.parse(data);
                paySlipReport.makeHTML();
                resp = paySlipReport.html;
                $("#portalWorkspace").css({ 'height' : ''});
            }
            //makeNavString(period);
            $("#report-workspace").html(resp);
        },
        error: function(data){
        	let msgText = "";
        	try{
        		let errorJSON = JSON.parse(data.responseText);
        		msgText = errorJSON.status + ": " + errorJSON.error;
        	}
        	catch(e){
        		msgText = "SERVER: Помилка отримання данних. " + e.message;
        	}
        	$("#report-workspace").html(`<h5 class="h5-error-data">${msgText}</h5>`);
        } 
    });
   /* $.getJSON("/astarta-portal/payslip/get?period="+period +"&edrpou=" + edrpou, function(data){
    	let resp = "";
        if(data.error!=undefined){
            resp = `<h3 class="h3-empty-date">Данні відсутні!</h3>`;
            $("#portalWorkspace").css({ 'height' : '550px'});
        }
        else{
        	paySlipReport.jsonObj = JSON.parse(data);
            paySlipReport.makeHTML();
            resp = paySlipReport.html;
            $("#portalWorkspace").css({ 'height' : ''});
        }
        //makeNavString(period);
        $("#report-workspace").html(resp);
    });*/
}


$("#paySlipYear-prev").on("click",function(){
    paySlipYear--;
    $("#paySlipYear-text").html(paySlipYear);
});

$("#paySlipYear-next").on("click",function(){
    paySlipYear++;
    $("#paySlipYear-text").html(paySlipYear);
});