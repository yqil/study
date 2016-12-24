! function() {
    var vm = new Vue({
        el: "#wxScratchCard",
        data: {
            prizeName: "小米智能手环",
            ctx: null,
            ifScratch: false,
            freeNum: 3,
            dialogMsg: "服务器开小差了，请稍后尝试~"
        },
        mounted: function(){
            this.setScratchLayer();
            
        },
        methods: {
            setScratchLayer: function(){
                var h = $("#prizeName").height();
                var w = $("#prizeName").width();
                //设置刮刮乐图层的宽高
                $("#scratchLayer").height(h-10);
                $("#scratchLayer").width(w-10);
                var ctx = this.getObjById("scratchLayer").getContext("2d");
                //绘制图层背景
                ctx.beginPath();
                ctx.fillStyle = "#B4B4B4";
                console.log(w+"-"+h);
                ctx.fillRect(0, 0, w+10, h);
                ctx.save();
                //绘制图层上的文字
                ctx.beginPath();
                ctx.font = "bold 18px 黑体";
                ctx.textBaseline = 'middle';//设置文本的垂直对齐方式
                ctx.textAlign = 'center'; //设置文本的水平对对齐方式
                ctx.fillStyle = "#F5F5F5";
                ctx.fillText("刮奖区", w/2, h/2);
                //让奖品名称显示出来
                ctx.globalCompositeOperation = 'destination-out';
                ctx.save();

                this.ctx = ctx;
                this.scratch();

            },
            scratch: function(){
                var that = this;
                $("#scratchLayer").on("mousedown", function(e){
                    e.preventDefault();
                    that.ifScratch = true;
                });
                $("#scratchLayer").on("mouseup", function(e){
                    e.preventDefault();
                    that.ifScratch = false;
                });
                $("#scratchLayer").on("mousemove", function(e){
                    if(that.ifScratch){
                        var x = (e.clientX + document.body.scrollLeft || e.pageX) || 0;
                        var y = (e.clientY + document.body.scrollTop || e.pageY) || 0;
                        that.ctx.beginPath();
                        that.ctx.arc(x,y,30,0,2*Math.PI,true);
                        that.ctx.fill();
                    }
                });
                $("#scratchLayer").on("touchstart", function(e){
                    e.preventDefault();
                    that.ifScratch = true;
                });

                $("#scratchLayer").on("touchend", function(e){
                    e.preventDefault();
                    that.ifScratch = false;
                });
                $("#scratchLayer").on("touchmove", function(e){
                    if(that.ifScratch){
                        //获取滑动的焦点的坐标
                        var x = e.touches[0].pageX - that.getObjById("prizeName").offsetLeft || 0;
                        var y = e.touches[0].pageY- $("#prizeName").offset().top || 0;
                        that.ctx.beginPath();
                        that.ctx.arc(x,y,20,0,2*Math.PI,true);
                        that.ctx.fill();
                        that.ctx.save();
                    }
                });
            },
            getObjById: function(id){
                return document.getElementById(id);
            }
        }
    });
}();