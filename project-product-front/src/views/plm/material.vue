<template>
  <div>

    <!--搜索框-->
    <div style="margin: 20px 0">
      <i-form inline>
        <Form-item>
          <i-input type="text" placeholder="材料名称">
            <Icon type="ios-person-outline" slot="prepend"></Icon>
          </i-input>
        </Form-item>
        <Form-item>
          <i-input type="text" placeholder="供应商">
            <Icon type="transgender" slot="prepend"></Icon>
          </i-input>
        </Form-item>
        <Form-item>
          <i-input type="text" placeholder="采购时间">
            <Icon type="email" slot="prepend"></Icon>
          </i-input>
        </Form-item>
        <Form-item>
          <i-input type="text" placeholder="采购者">
            <Icon type="ios-telephone" slot="prepend"></Icon>
          </i-input>
        </Form-item>
        <Form-item>
          <i-input type="text" placeholder="库存量">
            <Icon type="android-walk" slot="prepend"></Icon>
          </i-input>
        </Form-item>


        <Form-item>
          <i-button type="primary" click="#">搜索</i-button>
        </Form-item>
      </i-form>
    </div>

    <!--内容-->
    <i-table :columns="columns1" :data="data1" style="clear: both"></i-table>
    <Page :total="100" show-elevator></Page>
  </div>

</template>
<script>


  export default {
    data () {
      return {


        columns1: [
          {
            title: '材料名称',
            key: 'material_name'
          },
          {
            title: ' 采购时间',
            key: 'material_purc_tm'
          },
          {
            title: '供应商',
            key: 'material_supplier'
          },
          {
            title: '库存量',
            key: 'material_inventory'
          },
          {
            title: '采购者',
            key: 'user_name'
          }
        ],
        data1: [
          {
            user_name: '王小明',
            material_name: 'M单车原型',
            material_purc_tm: '2015-09-16 8:00',
            material_supplier: 'x企业',
            material_inventory: 0
          },
          {
            user_name: '李小丫',
            material_name: '单片机',
            material_purc_tm: '2013-08-06 8:00',
            material_supplier: '山西电子',
            material_inventory: 10
          },
          {
            user_name: '李小丫',
            material_name: '核心板',
            material_purc_tm: '2013-08-06 8:00',
            material_supplier: '山西电子',
            material_inventory: 10
          },
          {
            user_name: '李小丫',
            material_name: '蜂鸣器',
            material_purc_tm: '2013-08-06 8:00',
            material_supplier: '山西电子',
            material_inventory: 10
          },
          {
            user_name: '李小丫',
            material_name: '振动传感器',
            material_purc_tm: '2013-08-06 8:00',
            material_supplier: '山西电子',
            material_inventory: 10
          },
          {
            user_name: '李小丫',
            material_name: '蜂鸣器报警',
            material_purc_tm: '2013-08-06 8:00',
            material_supplier: '山西电子',
            material_inventory: 10
          },
          {
            user_name: '李小丫',
            material_name: '电机',
            material_purc_tm: '2013-08-06 8:00',
            material_supplier: '山西电子',
            material_inventory: 10
          },

        ]
      }
    }
  }
</script>
