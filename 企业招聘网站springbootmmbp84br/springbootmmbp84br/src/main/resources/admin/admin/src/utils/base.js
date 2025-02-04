const base = {
    get() {
        return {
            url : "http://localhost:8080/springbootmmbp84br/",
            name: "springbootmmbp84br",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbootmmbp84br/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "企业招聘网站"
        } 
    }
}
export default base
