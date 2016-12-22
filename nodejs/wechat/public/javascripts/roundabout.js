! function() {
    var vm = new Vue({
        el: "#wxRoundabout",
        data: {
            integral: 888,
            dialogMsg: "服务器开小差了，请稍后尝试~"
        },
        methods: {
            accessLottery: function(e){
                var type = $(e.target).data("type");
                var status = $(e.target).data("status");
                if(status == "1"){
                    if(type == "1"){
                        window.location.href = "/lottery/roundabout";
                    }else if(type == "2"){
                        window.location.href = "/lottery/scratchCard";
                    }else if(type == "3"){
                        window.location.href = "/lottery/goldEgg";
                    }
                }else if(status == "2"){
                    this.dialogMsg = "活动还未开始，敬请关注~";
                    this.myDialog.showDialog();
                }else if(status == "3"){
                    this.dialogMsg = "活动已结束，请关注其他活动~";
                    this.myDialog.showDialog();
                }
            }
        }
    });
}();