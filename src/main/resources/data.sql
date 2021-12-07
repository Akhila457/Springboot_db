[
    {
        "id": 5,
        "ruleKey": "myrule",
        "content": "package KieRule; import com.ofss.model.pojo; rule \"Allow\" when p1Object : com.ofss.model.pojo(device==1234); then p1Object.setMsg(\"proceed to login\");end;",
        "version": "2",
        "lastModifyTime": "37",
        "createTime": "75"
    },
    {
        "id": 4,
        "ruleKey": "rule",
        "content": "package KieRule; import com.ofss.model.pojo; rule \"block\" when p1Object : com.ofss.model.pojo(device==5678); then p1Object.setMsg(\"block user\");end;",
        "version": "3",
        "lastModifyTime": "637",
        "createTime": "875"
    }
]
