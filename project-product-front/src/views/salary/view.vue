<template>
  <div>

    <div style="float: left"><chart :options="productPeopleHistroy" ></chart></div>
    <div style="float: left"><chart :options="productPeople"></chart></div>

    <i-table :columns="columns1" :data="data1" style="clear: both"></i-table>
    <Page :total="100" show-elevator></Page>
  </div>

</template>
<script>

  let productPeople= {
    title : {
      text: '2017年各部门薪资',
      subtext: '日期统计日期：2017年12月'
    },
    tooltip : {
      trigger: 'axis'
    },
    legend: {
      data:['2017年各部门平均薪资   单位：元']
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
        data : ['采购','M单车生产','销售人员','物流人员','运维人员','销售人员']
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
        name:'M单薪资',
        type:'line',
        data:[1800, 2000,  1800, 1500, 1200, 1800],
        markLine : {
          data : [
            {type : 'average', name: '平均值'}
          ]
        }
      },
    ]
  };


  //人力资源耗费
  let productPeopleHistroy={
    title : {
      text: 'M单生产总人力资源消耗走势',
      subtext: '截止日期：2017年12月   单位：万元'
    },
    tooltip : {
      trigger: 'axis'
    },
    legend: {
      data:['M单生产人数']
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
        name:'M单薪资',
        type:'line',
        data:[80, 81, 80, 85, 83, 84, 83],
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

        productPeopleHistroy:productPeopleHistroy,
        productPeople:productPeople,


        columns1: [
          {
            title: '姓名',
            key: 'user_name'
          },
          {
            title: '岗位',
            key: 'work_name'
          },
          {
            title: '工位待遇',
            key: 'work_salary'
          },
          {
            title: '工作年限',
            key: 'work_year'
          },
          {
            title: '工作内容',
            key: 'work_content'
          }
        ],
        data1: [
          {
            user_name: '王小明',
            work_name: '采购人员',
            work_year:'5年',
            work_content:'负责单车原材料采购...',
            work_salary:3000
          },
          {
            user_name: '王小明',
            work_name: '运维人员',
            work_year:'5年',
            work_content:'负责单车原材料采购...',
            work_salary:1000
          },
          {
            user_name: '李小丫',
            work_name: '综合管理部',
            work_year:'2年',
            work_content:'负责管理人力资源调配...',
            work_salary:3000
          },
          {
            user_name: '付开明',
            work_name: '综合管理部',
            work_year:'3年',
            work_content:'HR总监...',
            work_salary:3300
          },
          {
            user_name: '吴伟明',
            work_name: '生产部',
            work_year:'3年',
            work_content:'负责将材料组装...',
            work_salary:3500
          },
          {
            user_name: '任凯',
            work_name: '质检部',
            work_year:'2年',
            work_content:'测试单车是否正确安装，功能健全,进行产品的一些测试.',
            work_salary:2800
          },
          {
            user_name: '何曲',
            work_name: '物流部',
            work_year:'3年',
            work_content:'负责生产好的进行搬运...',
            work_salary:3600
          },

        ]
      }
    }
  }
</script>
