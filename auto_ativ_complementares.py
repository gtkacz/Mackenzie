import re, time, json, warnings
from tqdm import tqdm
from bs4 import BeautifulSoup
from pathlib import Path
from selenium import webdriver
from selenium.common.exceptions import WebDriverException, TimeoutException

def tag_cleanup(html):
    html = str(html)
    cleanr = re.compile('<.*?>')
    string = (re.sub(cleanr, '', html))
    string = string.strip()
    return string

def main():
    CUR_DIR = Path(__file__).parent
    PROGRAM = 'geckodriver.exe'
    PATH = CUR_DIR / PROGRAM
    
    url = r'https://www3.mackenzie.br/tia/ativcompl/acpaCadastro.php?atv=23'
    
    OPTIONS = webdriver.FirefoxOptions()
    # OPTIONS.add_argument('--headless')
    OPTIONS.add_argument('--window-size=%s' % '1920,1080')
    
    try:
        DRIVER = webdriver.Firefox(PATH, options=OPTIONS)
        
    except WebDriverException:
        # OPTIONS.binary_location = 'D:\Program Files (x86)\Google\Chrome\Application\chrome.exe'
        # OPTIONS.add_experimental_option('excludeSwitches', ['enable-logging'])
        # DRIVER = webdriver.Chrome(PATH, options=OPTIONS)
        print('oi')
        
    finally:
        DRIVER.get(url)

if __name__ == '__main__':
    main()