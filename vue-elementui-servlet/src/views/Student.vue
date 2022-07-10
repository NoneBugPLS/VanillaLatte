<template>
    <el-card class="box-card">
<!--        搜索框-->
        <el-form :inline="true" :model="searchForm" class="demo-form-inline">
            <el-form-item >
                <el-input v-model="searchForm.sname" placeholder="学生姓名"></el-input>
            </el-form-item>
            <el-form-item >
                <el-input  v-model="searchForm.addr" placeholder="学生住址"></el-input>
            </el-form-item>
            <el-form-item >
                <el-select v-model="searchForm.cid" placeholder="学生班级">
                    <el-option label="所有班级" value="0"/>
                    <el-option v-for="c in classes" :key="c.cid" :label="c.cname" :value="c.cid" ></el-option>
                </el-select>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="search" icon="el-icon-search">查询</el-button>
                <el-button type="success" @click="add" icon="el-icon-plus">添加</el-button>
                <el-button type="danger" @click="handleDelete()" icon="el-icon-delete">批量删除</el-button>
            </el-form-item>
        </el-form>
        ${{multipleSelection}}
        <el-table
                :data="students"
                style="width: 100%"
                @selection-change="handleSelectionChange">
            <el-table-column
                    type="selection"
                    width="55">
            </el-table-column>>
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
                    width="150">
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
                            @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button
                            size="mini"
                            type="danger"
                            plain
                            @click="handleDelete(scope.row.sid)">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
<!--        分页导航-->
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
    export default {
        name: "Student",
        data() {
            //1. 自定义验证规则
            const checkAge = (rule, value, callback) => {
                if (!value) {
                    return callback(new Error('年龄不能为空！'))
                } else if (isNaN(value)) {
                    return callback(new Error("年龄只能是数字!"))
                }
                return callback();
            };
            return {
                students: [],
                multipleSelection: [],          //多选框
                classes: [],
                searchForm: {},          //查询学生
                page: 1,                //当前页
                pageSize: 5,            //每页大小
                total: 100,               //总条数
                dialogFormVisible: false,       //显示弹框
                title: "",                 //弹窗标题
                studForm: {},               //弹窗学生信息
                formLabelWidth: '120px',         //代表对话框中提示文本宽度
                rules: {                     //弹窗条件判断
                    sname: [{required: true, message: '学生不能为空', trigger: 'blur'}],
                    sex: [{required: true, message: '请选择学生姓别!', trigger: 'change'}],
                    age: [{validator: checkAge, trigger: 'blur'}],
                    addr: [{required: true, message: '学生住址不能为空!', trigger: 'blur'}],
                    cid: [{required: true, message: '请选择班级编号!', trigger: 'change'}],
                },
            }
        },
        created() {
            //1. 查询所有学生
            this.findAllStudents();
            //2. 查询所有班级
            this.findClasses();
            //3. 分页待条件查询
            //this.search();
        },
        methods: {
            //1. 查询所有学生
            findAllStudents() {
                this.axios.get("/student?cmd=list").then(data => {
                    console.log("data:", data);
                    this.students = data.data
                })
            },
            //2. 查询所有班级
            findClasses() {
                this.axios.get("/classes").then(data => {
                    this.classes = data.data
                })
            },
            //当pageSize大小发生改变时触发的方法
            handleSizeChange(pageSize) {
                console.log(`每页 ${pageSize} 条`);
                this.pageSize = pageSize;
                this.search();
            },
            //. 当page页大小改变时触发的方法
            handleCurrentChange(page) {
                console.log(`当前页: ${page}`);
                this.page = page;
                this.search();
            },
            //3. 分页待条件查询
            search() {
                this.axios.post(`/student?cmd=search&page=${this.page}&pageSize=${this.pageSize}`, "stud=" + JSON.stringify(this.searchForm)).then(data => {
                    if (data.data.code == 0) {
                        //5.1 更新总记录数
                        this.total = data.data.total;
                        //5.2 更新当前记录的集合
                        this.students = data.data.rows;
                    }
                })
            },
            //4. 添加学生           界面 之后save才是真正添加到数据哭
            add() {
                //1. 修改弹窗标题
                this.title = "添加学生";
                //2. 显示弹窗
                this.dialogFormVisible = true;
                //每次打开把弹窗清空
                this.studForm = {};
            },
            //5. 保存学生
            save() {
                const _this = this;
                //根据表单验证是否为添加或者修改
                this.$refs['ruleForm'].validate(valid => {            //valid代表表单里的验证都成功为true
                    if (valid) {
                        this.axios.post(`student?cmd=${this.studForm.sid ? 'update' : 'add'}`, 'stud=' + JSON.stringify(this.studForm)).then(data => {
                            if (data.data.code == 0) {
                                this.$message({
                                    message: `恭喜你 ${this.studForm.sid ? '修改' : '添加'} 学生成功！`,
                                    type: 'success',
                                    //关闭对话框然后刷新
                                    onClose() {
                                        //1. 此时再刷新页面
                                        _this.search();
                                    },
                                });
                            }
                            //关闭对话框
                            _this.dialogFormVisible = false;
                        })
                    }
                })
            },
            //6. 修改学生弹窗
            handleEdit(index, row) {
                //8.1 修改对话框标题
                this.title = "修改学生"
                //8.2 显示对话框
                this.dialogFormVisible = true;
                //8.3 将当前行的数据row赋值给表单中的studForm对象
                this.studForm = row;
            },
            //勾选框
            handleSelectionChange(val) {
                this.multipleSelection = val;
            },
            //7. 删除学生
            handleDelete(sid) {
                const _this = this;
                //1. 定义存放删除学生的id 数组
                let ids = [];
                //2 判断，根据sid是否有值，给数组赋值
                ids = sid ? [sid] : this.multipleSelection.map(m => m.sid);
                console.log("ids", ids)
                //3. 将信息传到后台进行删除
                //3.1 提示信息 确认删除？
                this.$confirm(`你真的要删除编号为[${ids}]的学生吗？`, '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {         //如果点了确定按钮
                    this.axios.get(`/student?cmd=delete&ids=${ids}`).then(data => {
                        if (data.data.code == 0) {
                            this.$message({
                                type: 'success',
                                message: '删除学生成功!',
                                onClose() {
                                    _this.search();     //重新刷新列表
                                }
                            });
                        }
                    })
                })

            }
        },
    }
</script>

<style scoped>
    .demo-form-inline{
        text-align: left;
    }
    .el-pagination{
        text-align: right;
        margin-top: 20px;
    }
</style>