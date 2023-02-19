import axios from 'axios';

// for cluster ip service [also do port forard from kubectl before using this service ]
// kubectl port-forward deployment/be-deploy 8080:8080
const CUSTOMER_API_BASE_URL = 'http://localhost:8080/api/version_1/customers';
// for node port
// const CUSTOMER_API_BASE_URL = 'http://192.168.15.5:30008/api/version_1/customers';
// for Loadbalancer service [here end point is localhost, so localhost will work here]
// const CUSTOMER_API_BASE_URL = 'http://localhost:8080/api/version_1/customers';
class CustomerService {

    getAllCustomers() {
        return axios.get(CUSTOMER_API_BASE_URL);
    }

    createCustomer(customer) {
        return axios.post(CUSTOMER_API_BASE_URL, customer);
    }

    getCustomerById(id) {
        return axios.get(CUSTOMER_API_BASE_URL + '/' + id);
    }

    updateCustomer(customer, id) {
        return axios.put(CUSTOMER_API_BASE_URL + '/' + id, customer);
    }

    deleteCustomer(id) {
        return axios.delete(CUSTOMER_API_BASE_URL + '/' + id);
    }

}

export default new CustomerService();