$(document).ready(function(){
//查票的日期選擇
    $(".datepicker1").datepicker({
        dayNamesMin:["日","一","二","三","四","五","六"],
        monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
        prevText:"上月",
        nextText:"次月",
        showMonthAfterYear:true,
        dateFormat:"yy-mm-dd",
    });
    $(".datepicker2").datepicker({
        dayNamesMin:["日","一","二","三","四","五","六"],
        monthNames:["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"],
        prevText:"上月",
        nextText:"次月",
        showMonthAfterYear:true,
        dateFormat:"yy-mm-dd",
    });


});