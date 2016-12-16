
! function() {
    var vm = new Vue({
        el: "#wxEditAddr",
        data: {
            name: null,
            phone: null,
            province: null,
            city: null,
            area: null,
            areaName: null,
            addrDetail: null,
            postCode: null,
            remark: null,
            dialogMsg: "服务器开小差了，请稍后尝试~",
            loaddingMsg: "保存中，请稍后~"
        }
        methods: {
            save: function(){
                var that = this;
                var data = {
                    data: {
                        mmh: this.mmh
                    }
                };
                this.myLoadding.showLoadding();
                $.getJSON('/person/saveUser', data, function(data, status, xhr){
                    if(data){
                        that.myLoadding.closeLoadding();
                        window.location.href="/person/index";
                    }else {
                        that.myLoadding.closeLoadding();
                        that.myDialog.showDialog();
                    }
                });
            }
        }
    });
}();