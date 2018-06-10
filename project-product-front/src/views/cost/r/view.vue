<template>

  <div>
    <Row style="margin: 20px 0px;">
      <div style="float: left;width: auto;height: auto">
        <span>请选择进行管理的产品：</span>
        <i-select :model.sync="model1" style="width:200px">
          <i-option v-for="item in productList" :value="item.value">{{item.label}}</i-option>
        </i-select>
      </div>
    </Row>
    <chart :options="rCostHistroy" style="float: left"></chart>
    <chart :options="rCostPeopleHistroy" style="float: left"></chart>
    <i-table :columns="columns1" :data="data1" style="clear: both"></i-table>
  </div>

</template>
<script>


  let  rCostHistroy = {
    title : {
      text: 'M单车近年来成本走势',
      subtext: '截止日期：2017年12月 单位：元'
    },
    tooltip : {
      trigger: 'axis'
    },
    legend: {
      data:['M单车投入']
    },
    toolbox: {
      show : true,
      feature : {
        mark : {show: true},
        dataView : {show: true, readOnly: false},
        magicType : {show: true, type: ['line', 'bar']},
        restore : {show: true},
        saveAsImage : {show: true}
      }
    },
    calculable : true,
    xAxis : [
      {
        type : 'category',
        boundaryGap : false,
        data : ['2011年','2012年','2013年','2014年','2015年','2016年','2017年']
      }
    ],
    yAxis : [
      {
        type : 'value',
        axisLabel : {
          formatter: '{value}'
        }
      }
    ],
    series : [
      {
        name:'M单车投入',
        type:'line',
        data:[300, 301, 331, 330, 298, 300, 310],
        markPoint : {
          data : [
            {type : 'max', name: '最大值'},
            {type : 'min', name: '最小值'}
          ]
        },
        markLine : {
          data : [
            {type : 'average', name: '平均值'}
          ]
        }
      },
    ]
  };

//人力资源耗费
  let rCostPeopleHistroy={
    title : {
      text: 'M单车研发人数',
      subtext: '截止日期：2017年12月'
    },
    tooltip : {
      trigger: 'axis'
    },
    legend: {
      data:['M单车研发人数']
    },
    toolbox: {
      show : true,
      feature : {
        mark : {show: true},
        dataView : {show: true, readOnly: false},
        magicType : {show: true, type: ['line', 'bar']},
        restore : {show: true},
        saveAsImage : {show: true}
      }
    },
    calculable : true,
    xAxis : [
      {
        type : 'category',
        boundaryGap : false,
        data : ['2011年','2012年','2013年','2014年','2015年','2016年','2017年']
      }
    ],
    yAxis : [
      {
        type : 'value',
        axisLabel : {
          formatter: '{value}'
        }
      }
    ],
    series : [
      {
        name:'M单车投入',
        type:'line',
        data:[10, 11, 8, 9, 10, 9, 10],
        markLine : {
          data : [
            {type : 'average', name: '平均值'}
          ]
        }
      },
    ]
  };

  export default {
    data () {
      return {
        productList: [
          {
            value: 'mdanche',
            label: 'M单车'
          },
          {
            value: 'suo',
            label: '锁'
          }
        ],
        rCostHistroy:rCostHistroy,//研究成本历年走势
        rCostPeopleHistroy:rCostPeopleHistroy,//研究成本历年走势


        columns1: [
          {
            title: '部门',
            key: 'org_name'
          },
          {
            title: '姓名',
            key: 'user_name'
          },
          {
            title: '岗位',
            key: 'work_name'
          },
          {
            title: '工作年限',
            key: 'work_year'
          },
          {
            title: '工作内容',
            key: 'work_content'
          },

        ],
        data1: [
          {
            org_name: '大数据部门',
            user_name: '王小明',
            work_name: 'java开发+大数据开发',
            work_year:'5年',
            work_content:'负责数据库建模，大数据开发...',
          },
          {
            org_name: '综合管理部',
            user_name: '李小丫',
            work_name: 'HR',
            work_year:'2年',
            work_content:'负责研发人员职业生涯...',
          },
          {
            org_name: '综合管理部',
            user_name: '付开明',
            work_name: '综合管理部',
            work_year:'3年',
            work_content:'HR总监...',
          },
          {
            org_name: 'java部门',
            user_name: '吴伟明',
            work_name: 'java开发',
            work_year:'3年',
            work_content:'业务逻辑...',
          },
          {
            org_name: '测试部',
            user_name: '任凯',
            work_name: '黑盒测试',
            work_year:'2年',
            work_content:'负责产品的一些测试.',
          },
          {
            org_name: '前端',
            user_name: '何曲',
            work_name: 'java开发',
            work_year:'3年',
            work_content:'负责数据库设计...',
          },
          {
            org_name: 'UI',
            user_name: '王明',
            work_name: '前端工程师',
            work_year:'4年',
            work_content:'UI设计...',
          },




        ]
      }
    }
  }
</script>
