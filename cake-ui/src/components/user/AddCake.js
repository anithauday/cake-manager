import React, {Component} from 'react'
import {Container} from 'semantic-ui-react'
import CakeTable from './CakeTable'
import AuthContext from '../context/AuthContext'
import {cakeApi} from '../misc/CakeApi'
import {handleLogError} from '../misc/Helpers'

class AddCake extends Component {
    static contextType = AuthContext

    state = {
        userMe: null,
        isUser: true,
        isLoading: false,
        cakeDescription: '',
        image: '',
        title: '',
        data: []
    }

    componentDidMount() {
        const Auth = this.context
        const user = Auth.getUser()
        const isUser = user.data.rol[0] === 'USER'
        this.setState({isUser})
        this.handleGetCakes()

    }

    handleInputChange = (e, {name, value}) => {
        this.setState({[name]: value})
    }

    handleGetCakes = () => {
        const Auth = this.context
        const user = Auth.getUser()

        this.setState({isLoading: true})
        cakeApi.getCakes(user)
            .then(response => {
                this.setState({data: response.data})
            })
            .catch(error => {
                handleLogError(error)
            })
            .finally(() => {
                this.setState({isLoading: false})
            })
    }
    handleCreateCake = () => {
        const Auth = this.context
        const user = Auth.getUser()

        let {cakeDescription} = this.state
        let {image} = this.state
        let {title} = this.state

        cakeDescription = cakeDescription.trim()
        image = image.trim()
        title = title.trim()

        const cake = {description: cakeDescription, image: image, title: title}
        cakeApi.createCake(user, cake)
            .then(() => {
                this.handleGetCakes()
                this.setState({cakeDescription: '', title: '', image: ''})
            })
            .catch(error => {
                handleLogError(error)
            })
    }

    render() {

            const {isLoading, cakeDescription ,data} = this.state
            return (
                <Container>
                    <CakeTable
                        cakes = {data}
                        isLoading={isLoading}
                        cakeDescription={cakeDescription}
                        handleCreateCake={this.handleCreateCake}
                        handleInputChange={this.handleInputChange}
                    />
                </Container>
            )

    }
}

export default AddCake