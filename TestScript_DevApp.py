import unittest
import requests


class MyApplicationTest(unittest.TestCase):
    def test_get_logs(self):
        try:
            # Test the /logs route
            response = requests.get('http://localhost:8080/logs')
            response.raise_for_status()  # Raise an exception for non-2xx status codes

            # Assert that the response content is not empty
            self.assertIsNotNone(response.content)

            # Assert that the response contains the expected logs
            expected_logs = 'Accessed endpoint: /logs'  # Replace with the expected logs
            self.assertIn(expected_logs, response.content.decode())
        except requests.HTTPError as e:
            self.fail(f"HTTP request failed: {e}")
        except requests.RequestException as e:
            self.fail(f"An error occurred during the request: {e}")

    def test_create_transaction(self):
        try:
            # Test the /transaction route
            response = requests.get('http://localhost:8080/transactions')
            response.raise_for_status()  # Raise an exception for non-2xx status codes

            # Assert that the response content is not empty
            self.assertIsNotNone(response.content)

            # Assert that the response message indicates a transaction was created
            expected_response = 'Transactions created'
            self.assertEqual(response.content.decode(), expected_response)
        except requests.HTTPError as e:
            self.fail(f"HTTP request failed: {e}")
        except requests.RequestException as e:
            self.fail(f"An error occurred during the request: {e}")


if __name__ == '__main__':
    unittest.main()
