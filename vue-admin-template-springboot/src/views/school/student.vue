<template>
    <el-card class="box-card">
        {{searchForm}}--
        <el-form :inline="true" :model="searchForm" class="demo-form-inline">
            <el-form-item>
                <el-input v-model="searchForm.sname" placeholder="学生姓名"></el-input>
            </el-form-item>
            <el-form-item>
                <el-input v-model="searchForm.addr" placeholder="学生住址"></el-input>
            </el-form-item>
            <el-form-item>
                <el-select v-model="searchForm.cid">
                    <el-option label="所有班级" value="0"/>
                    <el-option v-for="c in classes" :key="c.cid" :label="c.cname" :value="c.cid"/>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="search" icon="el-icon-search">查询</el-button>
                <el-button type="success" @click="add" icon="el-icon-plus">添加</el-button>
                <el-button type="danger" @click="handleDelete()" icon="el-icon-delete">批量删除</el-button>
            </el-form-item>
        </el-form>
        {{multipleSelection}}--
        <el-table
                :data="students"
                style="width: 100%"
                @selection-change="handleSelectionChange">
            <el-table-column
                    type="selection"
                    width="30">
            </el-table-column>
            <el-table-column
                    label="学号"
                    align="center"
                    prop="sid"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="sname"
                    label="姓名"
                    align="center"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="sex"
                    label="性别"
                    align="center"
                    width="100">
            </el-table-column>
            <el-table-column
                    prop="age"
                    label="年龄"
                    align="center"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="addr"
                    label="住址"
                    align="center"
                    width="180">
            </el-table-column>
            <el-table-column
                    prop="cname"
                    align="center"
                    label="所在班级"
                    width="180">
            </el-table-column>
            <el-table-column label="操作" align="center">
                <template slot-scope="scope">
                    <el-button
                            type="success"
                            plain
                            size="mini"
                            @click="handleEdit(scope.$index, scope.row)">编辑
                    </el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            plain
                            @click="handleDelete( scope.row.sid)">删除
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <!--分页导航-->
        <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="page"
                :page-sizes="[5, 10, 15, 20]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
        </el-pagination>
        <!--编辑学生的对话框-->
        <el-dialog :title="title" :visible.sync="dialogFormVisible" align="left" :close-on-click-modal="false">
            {{studForm}}--
            <el-form :model="studForm" :rules="rules" ref="ruleForm" >
                <el-form-item label="学生姓名" :label-width="formLabelWidth" prop="sname">
                    <el-input v-model="studForm.sname" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="学生性别" :label-width="formLabelWidth"  prop="sex">
                    <el-radio label="男" v-model="studForm.sex"></el-radio>
                    <el-radio label="女" v-model="studForm.sex"></el-radio>
                </el-form-item>
                <el-form-item label="学生年龄" :label-width="formLabelWidth"  prop="age">
                    <el-input v-model.number="studForm.age" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="学生住址" :label-width="formLabelWidth"  prop="addr">
                    <el-input v-model="studForm.addr" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="所在班级" :label-width="formLabelWidth"  prop="cid">
                    <el-select v-model="studForm.cid" placeholder="选择班级" style="width: 100%">
                        <el-option :label="c.cname" :value="c.cid" v-for="c in classes"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="save()">确 定</el-button>
            </div>
        </el-dialog>
    </el-card>

</template>

<script>
  import {findAllStudents, search, save,delStudent} from "@/api/student";
  import {findAllClasses} from "@/api/classes";

  export default {
        name: "Student",
        data() {
            //1. 自定义验证规则
            const checkAge = (rule,value,callback)=>{
                if(!value){
                    return callback(new Error('年龄不能为空！'))
                }else if(isNaN(value)){
                    return callback(new Error("年龄只能是数字!"))
                }
                return callback();
            };
            return {
                students: [],
                classes: [],
                searchForm:{},
                multipleSelection:[],
                page:1,
                pageSize:5,
                total:100,
                title:'',                   //对话框标题
                dialogFormVisible:false,    //对话框是否显示
                studForm:{},                //添加或修改的学生对象
                formLabelWidth:'120px',     //代表对话框中提示文本宽度
                rules:{                     //定义验证规则
                    sname:[{required:true,message:'学生姓名不能为空!',trigger:'blur'}],
                    sex:[{required:true,message:'请选择学生姓名!',trigger:'change'}],
                    age:[{validator:checkAge,trigger:'blur'}],
                    addr:[{required:true,message:'学生住址不能为空!',trigger:'blur'}],
                    cid:[{required:true,message:'请选择班级编号!',trigger:'change'}],
                },

            }
        },
        created() {
            //1. 查询所有学生
            //this.findAllStudents();
            //2. 查询所有班级
            this.findAllClasses();
            //3. 开始条件查询带分页
            this.search();
        },
        methods: {
            //1. 查询所有学生
            findAllStudents() {
                findAllStudents().then(data => {
                  console.log("data:",data);
                    this.students = data.data.list;
                })
            },
            //2. 查询所有的班级
            findAllClasses(){
              findAllClasses().then(data=>{
                this.classes = data.data.list;
              })
            },
            //3. 当pageSize大小发生改变时触发的方法
            handleSizeChange(pageSize) {
                console.log(`每页 ${pageSize} 条`);
                this.pageSize = pageSize;
                 this.search()

            },
            //4. 当page页大小改变时触发的方法
            handleCurrentChange(page) {
                console.log(`当前页: ${page}`);
                this.page = page;
                this.search()

            },
            //5. 开始条件查询带分页
            search(){
              search(this.page,this.pageSize,this.searchForm).then(data=>{
                if (data.code == 20000){
                  //总记录数
                  this.total = data.data.total;
                  //当前页的条信息
                  this.students = data.data.row;
                }
              })
            },
            //6. 添加学生(界面)
            add(){
                //6.1 修改对话框标题
                this.title = "添加学生";
                //6.2 显示对话框
                this.dialogFormVisible = true;
                //6.3 清空表单数据
                this.studForm = {}

            },
            //7. 保存学生(添加或修改学生)
            save(){
                const _this = this;
                //验证是添加还是修改？
              let url = `/student/add.do`;
              if(this.studForm.sid){
                url = '/student/update.do';
              }
                //7.1 根据表单是否验证通过决 定到后台进行添加或修改操作
                this.$refs['ruleForm'].validate(valid=>{        //valid: true:代表表单中所有的控件都验证通过，只要有一个不通过就是false
                    if(valid){
                       save(url,this.studForm).then(data=>{
                            if(data.code == 20000){
                                this.$message({
                                    message: `${this.studForm.sid ? '修改':'添加'}学生成功！`,
                                    type: 'success',
                                    onClose(){
                                        //1. 此时再刷新页面
                                        _this.search();
                                    }
                                });
                            }
                            //关闭对话框
                            _this.dialogFormVisible = false;
                        })
                    }
                })
            },
            //8. 修改学生（界面）
            handleEdit(index,row){
                //8.1 修改对话框标题
                this.title = "修改学生"
                //8.2 显示对话框
                this.dialogFormVisible = true;
                //8.3 将当前行的数据row赋值给表单中的studForm对象
                this.studForm = row;
            },
            //9. 删除学生
            handleDelete(sid){
                const _this = this;
                //9.1 定义要删除的学生id数组
                let ids = [];
                //9.2 根据sid参数是否有值，为ids数组进行赋值
                ids = sid ? [sid] : this.multipleSelection.map(m=>m.sid);
                console.log("ids:",ids);
                //9.3 将上面得到的数组提交到后台并进行删除
                this.$confirm(`你真的要删除编号为[${ids}]的学生吗？`, '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {         //如果点了确定按钮
                  delStudent(ids).then(data=>{
                        if(data.code == 20000){
                            this.$message({
                                type: 'success',
                                message: '删除学生成功!',
                                onClose(){
                                    _this.search();     //重新刷新列表
                                }
                            });
                        }
                    })
                })

            },
            //10. 多选
            handleSelectionChange(val) {
                this.multipleSelection = val;
            }
        },

    }
</script>

<style scoped>
    .el-card{
        text-align: left;
    }
    .el-pagination{
        text-align: right;
        margin-top: 20px;
    }
</style>
