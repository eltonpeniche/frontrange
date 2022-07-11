import { Button, Col, Form, Input, message, Row, Image } from "antd"
import React from "react"
import { useHistory } from "react-router-dom"
import { useAuth } from "../../context/AuthProvider/useAuth"



export const Login = () =>{
    const auth = useAuth()
    const history = useHistory();
    
    async function onFinish (values: {email:string, senha: string}){
        try {
            await auth.authenticate(values.email, values.senha)
            
            history.push("/lancamentos")
        } catch (error) {
            message.error(" Senha ou Email inválidos")
        }
    }
    
    
    return(
        <div>
        <Row  
            justify="center"
            align="middle"
            style={{
                height: '50vh'
            }}
        >
             <img src="https://zos.alipayobjects.com/rmsportal/jkjgkEfvpUPVyRjUImniVslZfWPnJuuZ.png" alt="Girl in a jacket" width="300" 
                 /> 
        </Row>
        <Row
            justify="center"
            align="middle"
        >
            <Col span={12}>
                  
    
                <Form
                    name="basic"
                    labelCol={{span:8}}
                    wrapperCol={{span:16}}
                    onFinish={onFinish}
                >
                    <Form.Item
                        label = "Email"
                        name = "email"
                    >
                        <Input/>
                    </Form.Item>

                    <Form.Item
                        label = "Senha"
                        name = "senha"
                    >
                        <Input.Password/>
                    </Form.Item>

                    <Form.Item wrapperCol={{ offset:8 , span:16}}>
                        <Button type="primary" htmlType="submit">
                            Sign in
                        </Button>
                    </Form.Item>

                </Form>
            </Col>
            
        </Row></div>
    )

}