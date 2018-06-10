//所有商品概览
export var allProductCostStatus = {
  title : {
    text: 'M企业产品生产成本概况',
    subtext: '价格 单位：元'
  },
  tooltip : {
    trigger: 'axis'
  },
  legend: {
    data:['M单车产品','锁产品']
  },
  toolbox: {
    show : true,
    feature : {
      mark : {show: true},
      dataView : {show: true, readOnly: false},
      magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
      restore : {show: true},
      saveAsImage : {show: true}
    }
  },
  calculable : true,
  xAxis : [
    {
      type : 'category',
      boundaryGap : false,
      data : ['研发阶段','制造阶段','销售阶段','运维阶段']
    }
  ],
  yAxis : [
    {
      type : 'value'
    }
  ],
  series : [
    {
      name:'M单车产品',
      type:'line',
      smooth:true,
      itemStyle: {normal: {areaStyle: {type: 'default'}}},
      data:[60, 133.57, 100, 30]
    },
    {
      name:'锁产品',
      type:'line',
      smooth:true,
      itemStyle: {normal: {areaStyle: {type: 'default'}}},
      data:[100, 30, 30, 0]
    },

  ]
};

//M企业产品市场占有情况
export  var allProductSaleStatus = {
  title : {
    text: 'M单车市场占有概况',
  },
  tooltip : {
    trigger: 'axis'
  },
  toolbox: {
    show : true,
    feature : {
      mark : {show: true},
      dataView : {show: true, readOnly: false},
      magicType: {show: true, type: ['line', 'bar']},
      restore : {show: true},
      saveAsImage : {show: true}
    }
  },
  calculable : true,
  legend: {
    data:['M单车']
  },
  xAxis : [
    {
      type : 'category',
      data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
    }
  ],
  yAxis : [
    {
      type : 'value',
      name : '市场占有量   单位：辆',
    }
  ],
  series : [

    {
      name:'M单车',
      type:'bar',
      data:[2.0, 4.9, 7.0, 23.2, 25.6, 76.7, 135.6, 162.2, 32.6, 20.0, 6.4, 3.3]
    }
  ]
};


//M企业工资分布
export var companySalary = {
  title : {
    text: 'M企业工资分布',
    subtext: '2017年11月',
    x:'center'
  },
  tooltip : {
    trigger: 'item',
    formatter: "{a} <br/>{b} : {c} ({d}%)"
  },
  legend: {
    orient : 'vertical',
    x : 'left',
    data:['制造部门','销售部门','其他费用','综合部门','研发部门','运维部门']
  },
  toolbox: {
    show : true,
    feature : {
      mark : {show: true},
      dataView : {show: true, readOnly: false},
      magicType : {
        show: true,
        type: ['pie', 'funnel'],
        option: {
          funnel: {
            x: '25%',
            width: '50%',
            funnelAlign: 'left',
            max: 1548
          }
        }
      },
      restore : {show: true},
      saveAsImage : {show: true}
    }
  },
  calculable : true,
  series : [
    {
      name:'工资分布',
      type:'pie',
      radius : '55%',
      center: ['50%', '60%'],
      data:[
        {value:335, name:'制造部门'},
        {value:310, name:'综合部门'},
        {value:234, name:'销售部门'},
        {value:135, name:'其他费用'},
        {value:1548, name:'研发部门'},
        {value:500, name:'运维部门'},
      ]
    }
  ]
};

