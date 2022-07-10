import request from '@/utils/request'

//1. 查询所有学生
export function findAllStudents() {
  return request({
    url: '/student/list.do',
    method: 'get'
  })
}
//2. 分页待条件查询
export function search(page,pageSize,data) {
  return request({
    url: `/student/search.do?page=${page}&pageSize=${pageSize}`,
    method: 'post',
    data     //这里是简化写法，就是因为key与value相等  data:data
  })
}
//3. 保存学生
export function save(url,data) {
  return request({
    url,
    method: 'post',
    data     //这里是简化写法，就是因为key与value相等  data:data
  })
}

//4. 删除学生
export function delStudent(ids) {
  return request({
    url:`/student/delete.do?ids=${ids}`,
    method: 'get',
  })
}

