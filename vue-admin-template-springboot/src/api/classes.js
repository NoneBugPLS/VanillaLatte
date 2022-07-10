import request from '@/utils/request'

export function findAllClasses() {
  return request({
    url: '/classes/list.do',
    method: 'get'
  })
}

