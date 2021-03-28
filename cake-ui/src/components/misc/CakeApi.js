import axios from 'axios'
import { config } from '../../Constants'
import { parseJwt } from './Helpers'

export const cakeApi = {
  authenticate,
  getUsers,
  getCakes,
  createCake,
  download
}

function authenticate(username, password) {
  return instance.post('/auth/login', { username, password }, {
    headers: { 'Content-type': 'application/json' , "Access-Control-Allow-Origin": "*"}
  })
}

function download(user) {
  return instance.get('/api/v1/cakes', {
    headers: {
      'Content-type': 'application/json',
      'Authorization': bearerAuth(user)
    }
    , responseType: 'blob', // important
  })
}

function getUsers(user, username) {
  const url = username ? `/api/users/${username}` : '/api/users'
  return instance.get(url, {
    headers: { 'Authorization': bearerAuth(user) }
  })
}

function getCakes(user) {
  const url = '/api/v1'
  return instance.get(url, {
    headers: { 'Authorization': bearerAuth(user) , "Access-Control-Allow-Origin": "*" }
  })
}

function createCake(user, cake) {
  return instance.post('/api/v1/cake', cake, {
    headers: {
      'Content-type': 'application/json',
      'Authorization': bearerAuth(user)
    }
  })
}


const instance = axios.create({
  baseURL: config.url.API_BASE_URL
})

instance.interceptors.request.use(function (config) {
  // If token is expired, redirect user to login
  if (config.headers.Authorization) {
    const token = config.headers.Authorization.split(' ')[1]
    const data = parseJwt(token)
    if (Date.now() > data.exp * 1000) {
      window.location.href = "/login"
    }
  }
  return config
}, function (error) {
  return Promise.reject(error)
})


function bearerAuth(user) {
  return `Bearer ${user.accessToken}`
}