
! function() {
    var vm = new Vue({
        el: "#wxEditPersonNickName",
        data: {
            nickName: null,
            dialogMsg: "服务器开小差了，请稍后尝试~"
        },
        mounted: function(){
            this.nickName = this.getQueryString("nickName");
        },
        methods: {

            save: function(){
                var data = {
                    data: {
                        nickName: this.nickName
                    }
                };
                $.getJSON('/person/saveUser', data, function(data, status, xhr){
                    if(data && data.status){
                        that.nickName = data.content.nickName;
                        that.mmh = data.content.mmh;
                        that.phone = data.content.phone;
                    }else {
                        that.myDialog.showDialog();
                    }
                });
            }
        }
    });
}();