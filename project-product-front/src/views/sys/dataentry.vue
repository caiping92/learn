<template>
  <div>


    <div style=" margin: 30px 10px;">
      <span style="font-family:Hiragino Sans GB; font-size: x-large;">数据资料录入</span>
      <Select vplaceholder="选择产品" style="width:200px">
        <Option value="beijing">M单车</Option>
      </Select>
    </div>
        <table class="table">
          <thead>
          <th colspan="2"> M单车研发投入情况</th><th> <TimePicker type="timerange" placement="bottom-end" placeholder="资料时间" style="width: 168px"></TimePicker>
          </th>
          </thead>
          <tr>
            <td>市场调研：</td>
            <td><Input  placeholder="请输入市场调研费用  单位：￥"></Input></td>
          </tr>
            <tr>
              <td>设计直接人工费用</td>
              <td><Input  placeholder="请输入设计直接人工费用  单位：￥"></Input>
              </td>
            </tr>
          <tr>
              <td>测试直接人工费用</td>
              <td><Input  placeholder="请输入测试直接人工费用  单位：￥"></Input>
              </td>
            </tr>

          <tr>
              <td>试验主体材料成本</td>
              <td><Input  placeholder="请输入主体材料成本  单位：￥"></Input>
              </td>
            </tr>
          <tr>
              <td>试验传动的材料成本</td>
              <td><Input  placeholder="请输入传动的材料成本  单位：￥"></Input>
              </td>
            </tr>
          <tr>
              <td>试验行动部分所花的总材料费用</td>
              <td><Input  placeholder="请输入行动部分所花的总材料费用  单位：￥"></Input>
              </td>
            </tr>
          <tr>
            <td>试验安全部分所花的总材料费用</td>
            <td><Input  placeholder="请输入安全部分所花的总材料费用  单位：￥"></Input>
            </td>
          </tr>
          <tr>
            <td>试验中其他材料费用</td>
            <td><Input  placeholder="请输入其他材料费用  单位：￥"></Input>
            </td>
          </tr>
  <tr>
            <td>研发阶段房租</td>
            <td><Input  placeholder="请输入研发阶段房租 单位：￥"></Input>
            </td>
          </tr>
<tr>
            <td>其他额外费用</td>
            <td><Input  placeholder="请输入其他额外费用（管理费） 单位：￥"></Input>
            </td>
          </tr>




        </table>


        <table class="table">
          <thead>
          <th >M单车制造投入情况情况表</th><th> <TimePicker type="timerange" placement="bottom-end" placeholder="资料时间" style="width: 168px"></TimePicker></th>
          </thead>
          <tr>
            <td>生产单位：</td>
            <td> <Select vplaceholder="选择生产单位">
              <Option value="beijing">M企业</Option>
            </Select></td>
            <td>产品名称</td>
            <td><Input  placeholder="请输入产品名称"></Input></td>
            <td>产品批号</td>
            <td><Input  placeholder="请输入产品批号"></Input></td>
            <td> 产品批量</td>
            <td> <Input  placeholder="请输入产品批量 单位：辆"></Input></td>
          </tr>


        </table>



    </Form>

  </div>

</template>
<script>


  export default {
    data () {
      return {
        value2: '1'
      }
    }
  }
</script>
