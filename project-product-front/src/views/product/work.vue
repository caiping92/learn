<template>
  <div>
    <Row style="margin: 20px 0px;">
      <div style="float: left;">
        <span>请选择进行管理的产品：</span>
        <i-select :model.sync="model1" style="width:200px">
          <i-option v-for="item in productList" :value="item.value">{{item.label}}</i-option>
        </i-select>
      </div>
    </Row>
    <!--M产品人力资源消耗-->
    <chart :options="productPeopleHistroy" style="float: left;width: 100%;"></chart>
    <i-table :columns="columns1" :data="data1" style="clear: both"></i-table>
  </div>

</template>
<script>



  //人力资源耗费
  let productPeopleHistroy={
    title : {
      text: 'M单生产人数',
      subtext: '截止日期：2017年12月'
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
        name:'M单生产人数',
        type:'line',
        data:[50, 60, 55, 61, 80, 70, 70],
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
        productPeopleHistroy:productPeopleHistroy,


        columns1: [
          {
            title: '岗位',
            key: 'work_name'
          },
          {
            title: '姓名',
            key: 'user_name'
          },
          {
            title: '工作年限',
            key: 'work_year'
          },
          {
            title: '工作内容',
            key: 'work_content'
          },
          {
            title: '工位待遇',
            key: 'work_salary'
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
