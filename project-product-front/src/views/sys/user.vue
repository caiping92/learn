<template>
  <div>

    <!--搜索框-->
    <div style="margin: 20px 0">
      <i-form inline>
        <Form-item >
          <i-input type="text"  placeholder="用户名">
            <Icon type="ios-person-outline" slot="prepend"></Icon>
          </i-input>
        </Form-item>
        <Form-item>
          <i-input type="text"  placeholder="性别">
            <Icon type="transgender" slot="prepend" ></Icon>
          </i-input>
        </Form-item>
        <Form-item>
          <i-input type="text"  placeholder="邮箱">
            <Icon type="email" slot="prepend"></Icon>
          </i-input>
        </Form-item>
        <Form-item>
          <i-input type="text"  placeholder="电话">
            <Icon type="ios-telephone"  slot="prepend"></Icon>
          </i-input>
        </Form-item>
        <Form-item>
          <i-input type="text"  placeholder="岗位">
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
