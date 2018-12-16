def helloWithoutParam(){
    println "start to call helloWithoutParam!"
    return "success, helloWithoutParam";
}

def helloWithParam(person, id){
    println "start to call helloWithParam, param{person:" + person + ", id:" + id + "}"
    return "success, helloWithParam";
}

def queue(queue,id){
    println("queue:"+id)
    int i = 0
    while(i <= 20){
        i++
        try {
            queue.put(i)
            println("queue into :"+i);
        } catch (InterruptedException e) {
            throw new Exception("失败"+e)
        }
        Thread.sleep(2000)
    }
    return  queue
}