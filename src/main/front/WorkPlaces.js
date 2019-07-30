import React, {Component} from "react";
import Axios from "axios";
import { Table, Button, Form, Label, Input, FormGroup } from "reactstrap"
import {Link} from "react-router-dom";

class WorkPlacesList extends Component {
    constructor(props) {
        super(props);
        this.state = {workPlaces : [], loading : true};
    }

    componentDidMount() {
        this.setState({contacts : [], loading : true});

            Axios.get('api/workplaces')
                .then(data => this.setState({workPlaces : data.data, loading : false}))
                .catch(error => console.log(error.data));
    }

    render() {
        if (this.state.loading == true) {
            return <p>Loading...</p>
        }

        return (
            <div>
                <Link to="/workplace/create">
                    <Button>Добавить</Button>
                </Link>
                <br/>
                <Table>
                    <thead><tr>
                            <th>Имя</th>
                            <th>Фамилия</th>
                            <th>Место работы</th>
                            <th>Адрес работы</th>
                    </tr></thead>
                    <tbody>
                        {
                            this.state.workPlaces.map(
                                workPlace =>
                                    <tr>
                                        <td>{workPlace.firstName}</td>
                                        <td>{workPlace.lastName}</td>
                                        <td>{workPlace.workPlace}</td>
                                        <td>{workPlace.workAddress}</td>
                                    </tr>
                            )
                        }
                    </tbody>
                </Table>
            </div>
        )
    }
}

export class WorkPlaceCreateDialog extends Component {
    constructor(prop) {
        super(prop);
        let defaultValues = {
            firstName : "",
            lastName : "",
            workPlace : "",
            workAddress : ""
        };
        this.state = {values: defaultValues};
        this.handleInputChange = this.handleInputChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleInputChange(event) {
        let values = this.state.values;
        values[event.target.name] = event.target.value.trim();
        this.setState({values : values});
    }

    handleSubmit(event) {
        event.preventDefault();
        const values = this.state.values;
        let error = [];
        if (values.firstName.length > 10 || values.firstName.length < 1) {
            error.push("Имя должно содержать от 1 до 10 символов");
        }
        if (values.lastName.length > 20 || values.lastName.length < 1) {
            error.push("Фамилия должна содержать от 1 до 20 символов");
        }
        if (values.workPlace.length > 20 || values.workPlace.length < 1) {
            error.push("Место работы не указано");
        }
        if (values.workAddress.length > 20 || values.workAddress.length < 1) {
            error.push("Адрес работы не указан");
        }

        if (error.length > 0) {
            alert(error.join(". "));
            return;
        }

        const router = this.props.history;
        Axios.post("/api/workplaces", values)
            .then(data => { router.push("/") })
            .catch(error => {
                console.log(error.data)
            });
    }

    render() {
        return (
            <Form onSubmit={this.handleSubmit}>
                <FormGroup>
                    <Label>Имя</Label>
                    <Input type="text" name="firstName" onChange={this.handleInputChange}/>
                </FormGroup>
                <FormGroup>
                    <Label>Фамилия</Label>
                    <Input type="text" name="lastName" onChange={this.handleInputChange}/>
                </FormGroup>
                <FormGroup>
                    <Label>Место работы</Label>
                    <Input type="text" name="workPlace" onChange={this.handleInputChange}/>
                </FormGroup>
                <FormGroup>
                    <Label>Адрес работы</Label>
                    <Input type="text" name="workAddress" onChange={this.handleInputChange}/>
                </FormGroup>
                <Button>Создать</Button>
            </Form>
        )
    }
}

export default WorkPlacesList;