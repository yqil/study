! function() {
    var vm = new Vue({
        el: "#wxRoundabout",
        data: {
            freeNum: 8,
            prizeList: [
                {phone: "187****6661", prizeName:"四件套床品套件"},
                {phone: "187****6662", prizeName:"小米智能手环"},
                {phone: "187****6663", prizeName:"吊篮藤椅"},
                {phone: "187****6664", prizeName:"100积分奖励"},
                {phone: "187****6665", prizeName:"500代金券"},
                {phone: "187****6666", prizeName:"四件套床品套件"},
                {phone: "187****6667", prizeName:"小米智能手环"},
                {phone: "187****6668", prizeName:"500代金券"},
                {phone: "187****6669", prizeName:"ipadmini"},
                {phone: "187****6610", prizeName:"iphone7plus"},
                {phone: "187****6611", prizeName:"四件套床品套件"},
                {phone: "187****6612", prizeName:"500代金券"},
                {phone: "187****6613", prizeName:"500代金券"},
                {phone: "187****6614", prizeName:"500代金券"},
                {phone: "187****6615", prizeName:"500代金券"}
                ],
            timer: null,
            winTimer: null,
            firstInitTop: 0,
            secondInitTop: 0,
            maxInitTop: 0,
            dialogMsg: "服务器开小差了，请稍后尝试~",
            currentPrizeImgNum: 0,
            initSpeed: 200,
            currentSpeed: 200,
            maxSpeed: 20,
            minSpeed: 200,
            addSpeed: -5,
            winNum: 0,
            lotterying: false,
            prizeInfo: [{
                name: "100积分", ifWin: true
            },{
                name: "500代金券", ifWin: true
            },{
                name: "吊篮藤椅", ifWin: true
            },{
                name: "四件套床品套件", ifWin: true
            },{
                name: "iphone7plus", ifWin: true
            },{
                name: "ipadmini", ifWin: true
            }, {
                name: "谢谢参与", ifWin: false
            }, {
                name: "小米智能手环", ifWin: true
            }],
            winMessage: "iphone"
        },
        mounted: function(){
            this.initPrizeRollList();
            // this.showDialog("wx-roundabout-win");
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
                if(this.lotterying){
                    return ;
                }
                this.lotterying = true;
                if(this.freeNum > 0){
                    this.winNum = Math.floor(Math.random()*8);
                    console.log(this.winNum);
                    this.currentSpeed = 200;
                    this.addSpeed = -5;
                    this.turntableRun();
                    this.freeNum = this.freeNum - 1;
                }else {
                    this.dialogMsg = "免费次数已用完，请关注其他活动~";
                    this.myDialog.showDialog();
                }
            },
            turntableRun: function(){
                this.clearStyle();
                $("#prize"+this.currentPrizeImgNum).addClass("wx-roundabout-click-img");
                
                if(this.currentSpeed <= this.maxSpeed){
                    this.addSpeed = -this.addSpeed;
                }
                this.currentSpeed += this.addSpeed; 
                if(this.addSpeed < 0 || this.currentSpeed < this.minSpeed){
                    if(this.currentPrizeImgNum >= 7){
                        this.currentPrizeImgNum = 0;
                    }else {
                        this.currentPrizeImgNum++;
                    }
                    setTimeout(this.turntableRun, this.currentSpeed);
                }else {
                    if((this.currentPrizeImgNum) != this.winNum){
                        if(this.currentPrizeImgNum >= 7){
                            this.currentPrizeImgNum = 0;
                        }else {
                            this.currentPrizeImgNum++;
                        }
                        setTimeout(this.turntableRun, this.currentSpeed);
                    }else {
                        this.lotterying = false;
                        var pi = this.prizeInfo[this.currentPrizeImgNum];
                        if(pi.ifWin){
                            this.winMessage = pi.name;
                            this.showDialog("wx-roundabout-win");
                        }else {
                            this.showDialog("wx-roundabout-noWin");
                        }
                    }
                }
            },
            winFlash: function(obj){
                if(obj.hasClass("wx-roundabout-click-img")){
                    obj.removeClass("wx-roundabout-click-img")
                }else {
                    obj.addClass("wx-roundabout-click-img");
                }
            },
            clearStyle: function(){
                $("#prize0").removeClass("wx-roundabout-click-img");
                $("#prize1").removeClass("wx-roundabout-click-img");
                $("#prize2").removeClass("wx-roundabout-click-img");
                $("#prize3").removeClass("wx-roundabout-click-img");
                $("#prize4").removeClass("wx-roundabout-click-img");
                $("#prize5").removeClass("wx-roundabout-click-img");
                $("#prize6").removeClass("wx-roundabout-click-img");
                $("#prize7").removeClass("wx-roundabout-click-img");
            },
            showDialog: function(className){
                $("."+className).css("display", "block");
                var e = "."+className+">div:nth-child(2)";
                var winHeight = window.innerHeight;
                var divHeight = $(e).height();
                var h = (winHeight-divHeight)/2;
                $(e).css("top", h+"px");
            }
        },
        components: {
            'fail-dialog': {
                template: '<div class="wx-roundabout-noWin">'+
                    '<div class="wx-roundabout-noWin-mask"></div>'+
                    '<div class="row wx-clear-margin wx-roundabout-noWin-content">'+
                        '<div class="col-xs-12 text-center wx-clear-padding">'+
                            '<img src="/images/wzjmmj.png" alt="图片无法显示" />'+
                        '</div>'+
                        '<div class="col-xs-12 text-center wx-clear-padding">'+
                            '太可惜了，差点就中奖了~'+
                        '</div>'+
                        '<div class="col-xs-12 text-center wx-clear-padding" v-on:click="closeDialog">'+
                            '我知道了'+
                        '</div>'+
                    '</div>'+
                '</div>',
                methods: {
                    closeDialog: function(){
                        $(".wx-roundabout-noWin").css("display", "none");
                    }
                }
            },
            "win-dialog": {
                props: ['message'],
                template: '<div class="wx-roundabout-win">'+
                    '<div class="wx-roundabout-win-mask"></div>'+
                    '<div class="row wx-clear-margin wx-roundabout-win-content">'+
                        '<div class="col-xs-12 text-center wx-clear-padding">'+
                            '<img src="/images/zjmmj.png" alt="图片无法显示" />'+
                        '</div>'+
                        '<div class="col-xs-12 text-center wx-clear-padding">'+
                            '恭喜你抽中了<span>{{ message }}<span>'+
                        '</div>'+
                        '<div class="col-xs-12 text-center wx-clear-padding">'+
                            '请及时在“我的礼品”领取'+
                        '</div>'+
                        '<div class="col-xs-12 text-center wx-clear-padding" v-on:click="closeDialog">'+
                            '我知道了'+
                        '</div>'+
                    '</div>'+
                '</div>',
                methods: {
                    closeDialog: function(){
                        $(".wx-roundabout-win").css("display", "none");
                    }
                }
            }
          }
    });
}();