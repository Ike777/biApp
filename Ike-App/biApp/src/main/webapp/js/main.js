console.log('111');
require.config({　　　　
    paths: {　　　　　　
    	"jquery":"/biApp/js/3rd/jquery3.2.1",
    	"async":"/biApp/js/3rd/async",
    	"echarts": "/biApp/js/3rd/eCharts/echarts",
        "bmap":"/biApp/js/3rd/eCharts/bmap"
        
        
    },
    shim: {
        'echarts': {
            deps: ['jquery'],
            exports: 'echarts'
        },
        'bmap':{
        	deps: ['jquery'],
            exports: 'bmap'
        }
    }　　
});

/*require(['echarts','bmap'],function($,echarts){
console.log(echarts);
})*/

//调用百度地图
define(['jquery','echarts','async!bmap'], function(){
    var map = new BMAP.Map("map");
    console.log('222');
});