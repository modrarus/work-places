import React, {Component} from "react";
import Axios from "axios";
import { Table } from "reactstrap"

class PhonesBook extends Component {
    constructor(props) {
        super(props);
        this.state = {contacts : [], loading : true}
    }

    componentDidMount() {
        this.setState({contacts : [], loading : true});

        Axios.get('api/contacts')
            .then(data => this.setState({contacts : data.data, loading : false}))
            .catch(error => console.log(error.data));
    }

    render() {
        if (this.state.loading == true) {
            return <p>Загрузка...</p>;
        }

        return (
            <Table>
                <thead>
                    <tr>
                        <th>Имя</th>
                        <th>Фамилия</th>
                        <th>Рабочий телефон</th>
                        <th>Мобильный телефон</th>
                        <th>Электронная почта</th>
                        <th>Место работы</th>
                        <th>День рождения</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        this.state.contacts.map(
                            contact =>
                                <tr>
                                    <td>{contact.firstName}</td>
                                    <td>{contact.lastName}</td>
                                    <td>{contact.phoneWork}</td>
                                    <td>{contact.firstMobile}</td>
                                    <td>{contact.email}</td>
                                    <td>{contact.workPlace}</td>
                                    <td>{contact.birthday}</td>
                                </tr>
                        )
                    }
                </tbody>
            </Table>
        )
    }
}

export default PhonesBook;