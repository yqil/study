! function() {
    var vm = new Vue({
        el: "#wxIntegralExchange",
        data: {
            integral: 888,
            total: 0,
            dialogMsg: "服务器开小差了，请稍后尝试~"
        },
        mounted: function(){
            var that = this;
        },
        methods: {
            selectRow: function(e){
                var picUrl = e.target.src;
                var num = $($($(e.target).parent().parent().children()[2]).children()[1]).val();
                var prize = $($($(e.target).parent().parent().children()[2]).children()[0]).data("prize");
                if(picUrl.indexOf("/images/circle-1@2x.png") > -1){
                    e.target.src = "/images/circle-2@2x.png";
                    this.total = this.total + prize * num;
                }else {
                    e.target.src = "/images/circle-1@2x.png";
                    this.total = this.total - prize * num;
                }
                if(this.total != 0 && this.total < this.integral){
                    $("#exchange").css("background-color", "#19B08F");
                }else {
                    $("#exchange").css("background-color", "#868686");
                }
            },
            addNum: function(e){
                var inputEle = $($(e.target).parent().children()[1]);
                var old = inputEle.val();
                inputEle.val(++old);
                var prize = $(e.target).data("prize");
                var picUrl = $($(e.target).parent().parent().children()[0]).children()[0].src;
                if(picUrl.indexOf("/images/circle-2@2x.png") > -1){
                    this.total = this.total + prize;
                }
                if(this.total < this.integral){
                    $("#exchange").css("background-color", "#19B08F");
                }else {
                    $("#exchange").css("background-color", "#868686");
                }
                
            },
            reduceNum: function(e){
                var inputEle = $($(e.target).parent().children()[1]);
                var old = inputEle.val();
                if(old == 1){
                    return ;
                }
                inputEle.val(--old);
                var prize = $(e.target).data("prize");
                var picUrl = $($(e.target).parent().parent().children()[0]).children()[0].src;
                if(picUrl.indexOf("/images/circle-2@2x.png") > -1){
                    this.total = this.total - prize;
                }
                if(this.total < this.integral){
                    $("#exchange").css("background-color", "#19B08F");
                }else {
                    $("#exchange").css("background-color", "#868686");
                }
            }
        }
    });
}();