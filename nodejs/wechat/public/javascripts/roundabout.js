! function() {
    var vm = new Vue({
        el: "#wxRoundabout",
        data: {
            freeNum: 8,
            prizeList: [
                {phone: "666****6666", prizeName:"四件套1"},
                {phone: "666****6666", prizeName:"四件套2"},
                {phone: "666****6666", prizeName:"四件套3"},
                {phone: "666****6666", prizeName:"四件套床品套件"},
                {phone: "666****6666", prizeName:"四件套床品套件"},
                {phone: "666****6666", prizeName:"四件套床品套件"},
                {phone: "666****6666", prizeName:"四件套床品套件"},
                {phone: "666****6666", prizeName:"四件套床品套件"},
                {phone: "666****6666", prizeName:"四件套床品套件"},
                {phone: "666****6666", prizeName:"四件套床品套件"},
                {phone: "666****6666", prizeName:"四件套床品套件"}
                ],
            timer: null,
            firstInitTop: 0,
            secondInitTop: 0,
            maxInitTop: 0,
            dialogMsg: "服务器开小差了，请稍后尝试~"
        },
        mounted: function(){
            this.initPrizeRollList();
        },
        methods: {
            initPrizeRollList: function(){
                var prizeListSize = 0;
                var strHtml = "";
                var len = this.prizeList.length;
                if(len % 2 == 1){
                    prizeListSize = Math.floor(len/2) +1;
                }else {
                    prizeListSize = Math.floor(len/2);
                }
                for(var i = 0; i < len; i += 2){
                    strHtml += '<ul class="row wx-clear-margin wx-roundabout-rollList-row">'+
                        '<li class="col-xs-3 text-center wx-clear-padding">'+this.prizeList[i].phone+'</li>'+
                        '<li class="col-xs-3 text-center wx-clear-padding">'+this.prizeList[i].prizeName+'</li>';
                    if(i < len - 1){
                        strHtml += '<li class="col-xs-3 text-center wx-clear-padding">'+this.prizeList[i+1].phone+'</li>'+
                            '<li class="col-xs-3 text-center wx-clear-padding">'+this.prizeList[i+1].prizeName+'</li>';
                    }
                    strHtml += '</ul>';
                }

                this.maxTop = 30 * prizeListSize;
                $("#firstRollList").html(strHtml);
                this.firstTop = 0;
                $("#firstRollList").css("top", "0");
                if(prizeListSize > 4){
                    $("#secondRollList").html(strHtml);
                    this.secondTop = this.maxTop ;
                    $("#secondRollList").css("top", this.secondTop+"px");
                    this.timer = setInterval(this.prizeListStartRoll, 1000);
                }
            },
            prizeListStartRoll: function(){
                this.firstTop = this.firstTop - 30;
                this.secondTop = this.secondTop - 30;
                if(-this.firstTop == this.maxTop && this.secondTop == 0){
                    this.firstTop = this.maxTop;
                }else if(-this.secondTop == this.maxTop && this.firstTop == 0){
                    this.secondTop = this.maxTop;
                }
                $("#firstRollList").css("top", this.firstTop+"px");
                $("#secondRollList").css("top", this.secondTop+"px");
            },
            startLottery: function(){
                
            }
        }
    });
}();