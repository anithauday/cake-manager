import React, {Component} from 'react'
import {Container} from 'semantic-ui-react'
import AuthContext from '../context/AuthContext'
import {cakeApi} from '../misc/CakeApi'
import {handleLogError} from '../misc/Helpers'

class Download extends Component {
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

        this.handleDownloadCakes()

    }

    handleInputChange = (e, {name, value}) => {
        this.setState({[name]: value})
    }

    handleDownloadCakes = () => {
        const Auth = this.context
        const user = Auth.getUser()

        this.setState({isLoading: true})
        cakeApi.download(user)
            .then(response => {
                const url = window.URL.createObjectURL(new Blob([response.data]));
                const link = document.createElement('a');
                link.href = url;
                link.setAttribute('download', 'cakes.xls');
                document.body.appendChild(link);
                link.click();
            })
            .catch(error => {
                handleLogError(error)
            })
            .finally(() => {
                this.setState({isLoading: false})
            })
    }

    render() {
        return (
            <div>

            </div>
        )
    }
}

export default Download