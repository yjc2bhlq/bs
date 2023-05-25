const base = {
    get() {
        return {
            url : "http://localhost:8080/bs/",
            name: "bs",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/bs/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "基于Java的校园失物招领管理系统"
        } 
    }
}
export default base
