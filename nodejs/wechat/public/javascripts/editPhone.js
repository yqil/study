
! function() {
    var vm = new Vue({
        el: "#wxEditMmh",
        data: {
            phone: null,
            dialogMsg: "服务器开小差了，请稍后尝试~"
        },
        mounted: function(){
            this.phone = this.getQueryString("phone");
        },
        methods: {

            save: function(){
                var data = {
                    data: {
                        phone: this.phone
                    }
                };
                $.getJSON('/person/saveUser', data, function(data, status, xhr){
                    if(data){
                        window.location.href="/person/index";
                    }else {
                        that.myDialog.showDialog();
                    }
                });
            }
        }
    });
}();